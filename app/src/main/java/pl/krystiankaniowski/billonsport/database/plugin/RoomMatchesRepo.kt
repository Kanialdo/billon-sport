package pl.krystiankaniowski.billonsport.database.plugin

import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import pl.krystiankaniowski.billonsport.core.data.Match
import pl.krystiankaniowski.billonsport.core.data.Team
import pl.krystiankaniowski.billonsport.core.repository.providers.MatchesRepo
import pl.krystiankaniowski.billonsport.database.AppDatabase
import pl.krystiankaniowski.billonsport.database.entities.MatchDB
import pl.krystiankaniowski.billonsport.database.entities.MatchMemberDB
import pl.krystiankaniowski.billonsport.database.entities.toCoreMatch

class RoomMatchesRepo constructor(val database: AppDatabase) : MatchesRepo {

	override fun insert(item: Match) {

		Single.fromCallable { database.eventDao().insertMatch(MatchDB(item.id, item.date, item.result)) }
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread()).subscribe()
	}

	override fun getPlayerMatches(playerId: Long): List<Match> {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}

	override fun update(item: Match) {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}

	override fun delete(item: Match) {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}

	override fun get(id: Long): Single<Match> {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}

	override fun getAll(): Flowable<List<Match>> {
		return database.eventDao().getAll()
				.subscribeOn(Schedulers.computation())
				.flatMap({ list ->
					Observable.fromIterable(list)
							.map({ item -> item.toCoreMatch() })
							.toList()
							.toFlowable()
				})
	}

	override fun insertMatchPlayers(matchId: String, team1: Team, team2: Team) {

		val membersPartial = team1.members.map { MatchMemberDB(matchId, it.id, 1) }.toMutableSet()
		membersPartial.addAll(team2.members.map { MatchMemberDB(matchId, it.id, 2) })
		val members = membersPartial.toList()

		Single.fromCallable { database.eventDao().insertMatchPlayers(members) }
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread()).subscribe()

	}

}