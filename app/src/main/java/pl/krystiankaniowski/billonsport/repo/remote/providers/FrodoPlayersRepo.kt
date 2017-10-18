package pl.krystiankaniowski.billonsport.repo.remote.providers

import io.reactivex.Flowable
import io.reactivex.Single
import pl.krystiankaniowski.billonsport.core.data.Player
import pl.krystiankaniowski.billonsport.core.repository.providers.PlayersRepo
import pl.krystiankaniowski.billonsport.repo.remote.FrodoPlayersApi
import pl.krystiankaniowski.billonsport.repo.remote.data.toPlayer
import retrofit2.Retrofit

class FrodoPlayersRepo : PlayersRepo {

	private val service: FrodoPlayersApi

	constructor(retrofit: Retrofit) {
		service = retrofit.create(FrodoPlayersApi::class.java)
	}

	override fun insert(item: Player) {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}

	override fun update(item: Player) {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}

	override fun delete(item: Player) {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}

	override fun get(id: Long): Single<Player> {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}

	override fun getAll(): Flowable<List<Player>> {
		return service.getPlayers().map { it -> it.map { webPlayer -> webPlayer.toPlayer() } }
	}

}