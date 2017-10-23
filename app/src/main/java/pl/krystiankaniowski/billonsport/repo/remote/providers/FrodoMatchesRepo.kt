package pl.krystiankaniowski.billonsport.repo.remote.providers

import io.reactivex.Flowable
import io.reactivex.Single
import pl.krystiankaniowski.billonsport.core.data.Match
import pl.krystiankaniowski.billonsport.core.repository.providers.MatchesRepo
import pl.krystiankaniowski.billonsport.repo.remote.FrodoMatchApi
import retrofit2.Retrofit

class FrodoMatchesRepo : MatchesRepo {

	private val service: FrodoMatchApi

	constructor(retrofit: Retrofit) {
		service = retrofit.create(FrodoMatchApi::class.java)
	}

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
		//return service.getMatches().map { it -> it.map { webMatch -> webMatch.toMatch() } }
	}

}