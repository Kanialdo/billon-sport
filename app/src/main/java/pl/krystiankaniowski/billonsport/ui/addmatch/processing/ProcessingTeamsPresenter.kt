package pl.krystiankaniowski.billonsport.ui.addmatch.processing

import io.reactivex.android.schedulers.AndroidSchedulers
import pl.krystiankaniowski.billonsport.core.data.Player
import pl.krystiankaniowski.billonsport.core.repository.Repository
import pl.krystiankaniowski.billonsport.core.shuffler.Shuffler
import pl.krystiankaniowski.billonsport.core.shuffler.TrueSkillShuffler
import pl.krystiankaniowski.billonsport.mvp.BasePresenter
import pl.krystiankaniowski.billonsport.ui.addmatch.AddMatchFlow
import pl.krystiankaniowski.billonsport.ui.data.PlayerUI
import javax.inject.Inject

class ProcessingTeamsPresenter @Inject constructor() : BasePresenter<ProcessingTeamsContract.View>(), ProcessingTeamsContract.Presenter {

	private val TAG = "ProcessingTeamsP"

	@Inject
	lateinit var repo: Repository

	@Inject
	lateinit var flow: AddMatchFlow

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
	}

	private fun getPlayers() {

		view?.setShufflingButtonEnable(false)
		view?.setCreateButtonEnable(false)
		view?.setShufflingView("Losowanie")

		repo.getPlayers().getAll()
				.map { list -> list.filter { player -> player.id in flow.getBundle().playersIds } }
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(
						{ list -> processTeams(list) },
						{ error -> view?.setErrorView(error.message) }
				)

	}

	private fun processTeams(list: List<Player>) {

		val team1 = list.filterIndexed({ id, _ -> id % 2 == 0 })
		val team2 = list.filterIndexed({ id, _ -> id % 2 == 1 })

		val matchQuality = shuffler.getMatchQuality(team1, team2)

		val uiTeam1 = team1.map { PlayerUI.fromPlayer(it) }
		val uiTeam2 = team2.map { PlayerUI.fromPlayer(it) }

		view?.setShufflingButtonEnable(true)
		view?.setCreateButtonEnable(true)
		view?.setResultView(uiTeam1, uiTeam2, "MatchQuality to $matchQuality")

	}

}