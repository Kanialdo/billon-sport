package pl.krystiankaniowski.billonsport.ui.match

import org.junit.Test
import pl.krystiankaniowski.billonsport.core.data.Player
import pl.krystiankaniowski.billonsport.core.shuffler.Shuffler
import pl.krystiankaniowski.billonsport.core.shuffler.TrueSkillShuffler
import pl.krystiankaniowski.billonsport.mock.Players

class UnfinishedMatchPresenterTest {

	val instance = UnfinishedMatchPresenter()

	@Test
	fun processMatchResult() {

		val team1: List<Player> = listOf(Players.kania())
		val team2: List<Player> = listOf(Players.malyKania())

		val players = instance.process(team1 = team1, team2 = team2, result = Shuffler.MatchResult.DRAW)

		for (player in players) {
			println(player)
		}

	}

}

class UnfinishedMatchPresenter {

	val shuffler: Shuffler = TrueSkillShuffler()

	fun process(team1: List<Player>, team2: List<Player>, result: Shuffler.MatchResult): List<Player> {
		return shuffler.calculateNewRatings(team1, team2, result).filter { !it.virtual }
	}

}


