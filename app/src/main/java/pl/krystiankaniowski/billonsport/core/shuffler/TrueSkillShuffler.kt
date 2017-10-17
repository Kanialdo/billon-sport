package pl.krystiankaniowski.billonsport.core.shuffler

import jskills.GameInfo
import jskills.Rating
import jskills.Team
import jskills.TrueSkillCalculator
import pl.krystiankaniowski.billonsport.core.data.Player

class TrueSkillShuffler : Shuffler {

	override fun getMatchQuality(team1: List<Player>, team2: List<Player>): Double {

		val innerTeam1 = Team()
		val innerTeam2 = Team()

		for (player in team1) {
			innerTeam1.addPlayer(jskills.Player(player.id), Rating(player.rating.mean.toDouble(), player.rating.unconfident.toDouble()))
		}

		for (player in team2) {
			innerTeam2.addPlayer(jskills.Player(player.id), Rating(player.rating.mean.toDouble(), player.rating.unconfident.toDouble()))
		}

		return TrueSkillCalculator.calculateMatchQuality(GameInfo.getDefaultGameInfo(), listOf(innerTeam1, innerTeam2))

	}

}
