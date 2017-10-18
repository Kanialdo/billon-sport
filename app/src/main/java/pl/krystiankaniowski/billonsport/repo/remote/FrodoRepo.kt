package pl.krystiankaniowski.billonsport.repo.remote

import pl.krystiankaniowski.billonsport.core.repository.Repository
import pl.krystiankaniowski.billonsport.core.repository.providers.MatchesRepo
import pl.krystiankaniowski.billonsport.core.repository.providers.PlayersRepo
import pl.krystiankaniowski.billonsport.core.repository.providers.RatingRepo
import pl.krystiankaniowski.billonsport.repo.remote.providers.FrodoMatchesRepo
import pl.krystiankaniowski.billonsport.repo.remote.providers.FrodoPlayersRepo
import pl.krystiankaniowski.billonsport.repo.remote.providers.FrodoRatingRepo
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class FrodoRepo : Repository {

	private val players: FrodoPlayersRepo
	private val matches: FrodoMatchesRepo
	private val rating: FrodoRatingRepo

	private val BASE_URL = "http://frodo.billon.io:4200/"

	init {

		val retrofit = Retrofit.Builder()
				.baseUrl(BASE_URL)
				.addConverterFactory(GsonConverterFactory.create())
				.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
				.build()

		players = FrodoPlayersRepo(retrofit)
		matches = FrodoMatchesRepo()
		rating = FrodoRatingRepo()

	}

	override fun getPlayers(): PlayersRepo = players

	override fun getMatches(): MatchesRepo = matches

	override fun getRatings(): RatingRepo = rating

}