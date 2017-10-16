package pl.krystiankaniowski.billonsport.core.repository.providers

import pl.krystiankaniowski.billonsport.core.data.RatingChange
import pl.krystiankaniowski.billonsport.core.repository.exceptions.RepoException

interface RatingRepo : CommonRepo<RatingChange> {

	@Throws(RepoException::class)
	fun getPlayerLifetimeRatingHistory(playerId: Long): List<RatingChange>

}