package pl.krystiankaniowski.billonsport.ui.addmatch.processing

import io.reactivex.android.schedulers.AndroidSchedulers
import pl.krystiankaniowski.billonsport.core.data.Match
import pl.krystiankaniowski.billonsport.core.data.Player
import pl.krystiankaniowski.billonsport.core.data.Rating
import pl.krystiankaniowski.billonsport.core.repository.Repository
import pl.krystiankaniowski.billonsport.core.shuffler.Shuffler
import pl.krystiankaniowski.billonsport.core.shuffler.TrueSkillShuffler
import pl.krystiankaniowski.billonsport.mvp.BasePresenter
import pl.krystiankaniowski.billonsport.ui.addmatch.AddMatchFlow
import pl.krystiankaniowski.billonsport.ui.data.PlayerUI
import java.util.*
import javax.inject.Inject

class ProcessingTeamsPresenter @Inject constructor() : BasePresenter<ProcessingTeamsContract.View>(), ProcessingTeamsContract.Presenter {

	private val TAG = "ProcessingTeamsP"

	@Inject
	lateinit var repo: Repository

	@Inject
	lateinit var flow: AddMatchFlow

	private var match: Match? = null

	var shuffler: Shuffler = TrueSkillShuffler()

	override fun onSubscribe() {
		getPlayers()
	}

	override fun onUnsubscribe() {
	}

	override fun shuffleButtonClicked() {
		getPlayers()
	}

	override fun createMatchButtonClicked() {
		if (match != null) {
			repo.getMatches().insert(match!!)
			repo.getMatches().insertMatchPlayers(match!!.id, match!!.team1, match!!.team2)
			flow.showMatchView()
		}
	}

	private fun getPlayers() {

		match = null

		view?.setShufflingButtonEnable(false)
		view?.setCreateButtonEnable(false)
		view?.setShufflingView("Losowanie")

		repo.getPlayers().getAll()
				.map { list -> list.filter { player -> player.id in flow.getBundle().playersIds } }
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(
						{ list ->
							//							if (list.size % 2 != 0) {
//								val list2 = list.toMutableList()
//								list2.add(createVirtualPlayer(list)!!)
//								processTeams(list2.toList())
//							} else {
							processTeams(list)
//							}
						},
						{ error -> view?.setErrorView(error.message) }
				)

	}

	private fun processTeams(list: List<Player>) {

		Collections.shuffle(list)

		val teams = List(flow.getBundle().teamsCount, { index -> list.filterIndexed({ id, _ -> id % flow.getBundle().teamsCount == index }) })
		var matchQuality = 1.0

		for (i in 0..teams.size - 2) {
			for (j in i..teams.size - 1) {
				val partialMatchQuality = shuffler.getMatchQuality(teams[i], teams[j])
				if (partialMatchQuality < matchQuality) {
					matchQuality = partialMatchQuality
				}
			}
		}

		val uiTeams = teams.map { it.map { PlayerUI.fromPlayer(it) } }

		// match = Match(RandomString(16).nextString(), System.currentTimeMillis(), Team(team1.toSet()), Team(team2.toSet()), MatchResult.UNKNOWN)

		view?.setShufflingButtonEnable(true)
		view?.setCreateButtonEnable(true)
		view?.setResultView(uiTeams, "Najgorszy MatchQuality to $matchQuality")

	}

	internal fun createVirtualPlayer(players: List<Player>): Player? {
		return if (players.size % 2 > 0) {
			var averageMean = 0f
			var averageUnconfident = 0f
			for (player in players) {
				averageMean += player.rating.mean
				averageUnconfident += player.rating.standardDeviation
			}
			Player("0", "virtual", "virtual", "virtual", Rating(averageMean / players.size, averageUnconfident / players.size), true)
		} else {
			null
		}
	}

}