package pl.krystiankaniowski.billonsport.core.shuffler

import pl.krystiankaniowski.billonsport.core.data.Player

interface Shuffler {

	enum class MatchResult {
		TEAM_1,
		TEAM_2,
		DRAW,
		PENDING
	}

	fun getMatchQuality(team1: List<Player>, team2: List<Player>): Double

	fun calculateNewRatings(team1: List<Player>, team2: List<Player>, result: MatchResult): List<Player>

}