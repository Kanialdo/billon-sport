package pl.krystiankaniowski.billonsport.core.repository

import pl.krystiankaniowski.billonsport.core.data.RatingChange
import pl.krystiankaniowski.billonsport.core.repository.exceptions.RepoException

interface RatingRepo : CommonRepository<RatingChange> {

	@Throws(RepoException::class)
	fun getPlayerLifetimeRatingHistory(playerId: Long): List<RatingChange>

}