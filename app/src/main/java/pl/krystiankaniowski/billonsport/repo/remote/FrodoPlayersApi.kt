package pl.krystiankaniowski.billonsport.repo.remote

import io.reactivex.Flowable
import pl.krystiankaniowski.billonsport.repo.remote.data.WebPlayer
import retrofit2.http.GET

interface FrodoPlayersApi {

	@GET("players")
	fun getPlayers(): Flowable<List<WebPlayer>>

}