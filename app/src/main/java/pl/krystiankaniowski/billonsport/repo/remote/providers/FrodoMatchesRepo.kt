package pl.krystiankaniowski.billonsport.repo.remote.providers

import io.reactivex.Flowable
import io.reactivex.Single
import pl.krystiankaniowski.billonsport.core.data.Match
import pl.krystiankaniowski.billonsport.core.repository.providers.MatchesRepo

class FrodoMatchesRepo : MatchesRepo {

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