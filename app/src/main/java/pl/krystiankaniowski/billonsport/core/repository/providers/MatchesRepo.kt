package pl.krystiankaniowski.billonsport.core.repository

import pl.krystiankaniowski.billonsport.core.data.Match
import pl.krystiankaniowski.billonsport.core.repository.exceptions.RepoException

interface MatchesRepo : CommonRepository<Match> {

	@Throws(RepoException::class)
	fun getPlayerMatches(playerId: Long): List<Match>

}