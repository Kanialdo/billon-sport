package pl.krystiankaniowski.billonsport.database.plugin

import io.reactivex.Flowable
import io.reactivex.Single
import pl.krystiankaniowski.billonsport.core.data.Match
import pl.krystiankaniowski.billonsport.core.repository.providers.MatchesRepo
import pl.krystiankaniowski.billonsport.database.AppDatabase

class RoomMatchesRepo constructor(val database: AppDatabase) : MatchesRepo {

	override fun insert(item: Match) {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}

}