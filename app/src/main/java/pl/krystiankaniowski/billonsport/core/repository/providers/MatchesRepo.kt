package pl.krystiankaniowski.billonsport.core.repository.providers

import pl.krystiankaniowski.billonsport.core.data.Match
import pl.krystiankaniowski.billonsport.core.repository.exceptions.RepoException

interface MatchesRepo : CommonRepo<Match> {

	@Throws(RepoException::class)
	fun getPlayerMatches(playerId: Long): List<Match>

}