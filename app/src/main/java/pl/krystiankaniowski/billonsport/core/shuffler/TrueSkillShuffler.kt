package pl.krystiankaniowski.billonsport.core.shuffler

import jskills.GameInfo
import jskills.IPlayer
import jskills.ITeam
import jskills.TrueSkillCalculator
import pl.krystiankaniowski.billonsport.core.data.Player
import pl.krystiankaniowski.billonsport.core.data.Rating

class TrueSkillShuffler : Shuffler {

	override fun getMatchQuality(team1: List<Player>, team2: List<Player>): Double {
		return TrueSkillCalculator.calculateMatchQuality(GameInfo.getDefaultGameInfo(), listOf(team1.toSkillTeam(), team2.toSkillTeam()))
	}

	override fun calculateNewRatings(team1: List<Player>, team2: List<Player>, result: Shuffler.MatchResult): List<Player> {

		val players = team1.union(team2).associateBy({ it.id })

		return when (result) {
			Shuffler.MatchResult.LEFT -> TrueSkillCalculator.calculateNewRatings(GameInfo.getDefaultGameInfo(), listOf(team1.toSkillTeam(), team2.toSkillTeam()), 1, 2)
			Shuffler.MatchResult.DRAW -> TrueSkillCalculator.calculateNewRatings(GameInfo.getDefaultGameInfo(), listOf(team1.toSkillTeam(), team2.toSkillTeam()), 1, 1)
			Shuffler.MatchResult.RIGTH -> TrueSkillCalculator.calculateNewRatings(GameInfo.getDefaultGameInfo(), listOf(team1.toSkillTeam(), team2.toSkillTeam()), 2, 1)
			Shuffler.MatchResult.PENDING -> throw IllegalStateException()
		}.toCorePlayers(players)

	}

}

private fun List<Player>.toSkillTeam(): ITeam {
	val output = jskills.Team()
	for (player in this) {
		output.addPlayer(jskills.Player(player.id), jskills.Rating(player.rating.mean.toDouble(), player.rating.unconfident.toDouble()))
	}
	return output
}

private fun Map<IPlayer, jskills.Rating>.toCorePlayers(players: Map<String, Player>): List<Player> {
	return this.map { (player, rating) ->
		player as jskills.Player<String>
		val cachedPlayer = players[player.id]!!
		Player(cachedPlayer.id, cachedPlayer.nickname, cachedPlayer.firstName, cachedPlayer.lastName, Rating(rating.mean.toFloat(), rating.standardDeviation.toFloat()))
	}
}


