package pl.krystiankaniowski.billonsport.ui.match

import io.reactivex.android.schedulers.AndroidSchedulers
import pl.krystiankaniowski.billonsport.BillonSportApplication
import pl.krystiankaniowski.billonsport.core.data.Match
import pl.krystiankaniowski.billonsport.core.data.Team
import pl.krystiankaniowski.billonsport.core.repository.Repository
import pl.krystiankaniowski.billonsport.core.shuffler.Shuffler
import pl.krystiankaniowski.billonsport.core.shuffler.TrueSkillShuffler
import pl.krystiankaniowski.billonsport.database.AppDatabase
import pl.krystiankaniowski.billonsport.database.converters.DatabaseConverters
import pl.krystiankaniowski.billonsport.database.dao.PlayerDBWithTeam
import pl.krystiankaniowski.billonsport.mvp.BasePresenter
import javax.inject.Inject

/**
 * Created by kryst on 24.10.2017.
 */

class MatchDetailsPresenter @Inject constructor() : BasePresenter<MatchDetailsContract.View>(), MatchDetailsContract.Presenter {

	val TAG = "MatchDetailsPresenter"

	@Inject
	lateinit var repository: Repository

	@Inject
	lateinit var database: AppDatabase

	var shuffler: Shuffler = TrueSkillShuffler()

	var match: Match? = null
	var players: List<PlayerDBWithTeam>? = null

	var team1: Team? = null
	var team2: Team? = null

	val matchId = BillonSportApplication.temp_match_id!!

	// ---------------------------------------------------------------------------------------------

	override fun onSubscribe() {

		repository.getMatches().get(matchId)
				.subscribeOn(AndroidSchedulers.mainThread())
				.subscribe { match ->
					this.match = match
					requestMatchMembers()
				}

	}

	override fun onUnsubscribe() {
	}

	// ---------------------------------------------------------------------------------------------

	override fun clickTeam1Win() {
		updateReults(Shuffler.MatchResult.TEAM_1)
	}

	override fun clickTeam2Win() {
		updateReults(Shuffler.MatchResult.TEAM_2)
	}

	override fun clickDraw() {
		updateReults(Shuffler.MatchResult.DRAW)
	}

	// ---------------------------------------------------------------------------------------------

	private fun requestMatchMembers() {

		database.eventDao().getMatchPlayers(matchId)
				.subscribeOn(AndroidSchedulers.mainThread())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe { players ->
					this.players = players
					team1 = Team(players.filter { it.team == 1 }.map { DatabaseConverters.toCorePlayer(it.player) }.toSet())
					team2 = Team(players.filter { it.team == 2 }.map { DatabaseConverters.toCorePlayer(it.player) }.toSet())
					view?.setTeams(team1?.members!!.toList(), team2?.members!!.toList())
				}
	}

	private fun updateReults(result: Shuffler.MatchResult) {
		val calculateNewRatings = shuffler.calculateNewRatings(team1?.members!!.toList(), team2?.members!!.toList(), result)

		Thread {
			for (player in calculateNewRatings) {
				repository.getPlayers().update(player)
			}
		}.start()

	}

}