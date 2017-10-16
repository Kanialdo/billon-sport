package pl.krystiankaniowski.billonsport.core.repository

import pl.krystiankaniowski.billonsport.core.repository.providers.MatchesRepo
import pl.krystiankaniowski.billonsport.core.repository.providers.PlayersRepo
import pl.krystiankaniowski.billonsport.core.repository.providers.RatingRepo

interface Repository {

	fun getPlayers(): PlayersRepo

	fun getMatches(): MatchesRepo

	fun getRatings(): RatingRepo

}