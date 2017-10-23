package pl.krystiankaniowski.billonsport.repo.remote

import io.reactivex.Flowable
import pl.krystiankaniowski.billonsport.repo.remote.data.WebMatch
import retrofit2.http.GET

interface FrodoMatchApi {

	@GET("match")
	fun getMatches(): Flowable<List<WebMatch>>

}