package pl.krystiankaniowski.billonsport.database.plugin

import pl.krystiankaniowski.billonsport.core.repository.Repository
import pl.krystiankaniowski.billonsport.core.repository.providers.MatchesRepo
import pl.krystiankaniowski.billonsport.core.repository.providers.PlayersRepo
import pl.krystiankaniowski.billonsport.core.repository.providers.RatingRepo
import pl.krystiankaniowski.billonsport.database.AppDatabase

class RoomRepository(val database: AppDatabase) : Repository {

	val players = RoomPlayersRepo(database)
	val matches = RoomMatchesRepo(database)
	val ratings = RoomRatingRepo(database)

	override fun getPlayers(): PlayersRepo = players

	override fun getMatches(): MatchesRepo = matches

	override fun getRatings(): RatingRepo = ratings

}