package pl.krystiankaniowski.billonsport

import org.junit.Test
import pl.krystiankaniowski.billonsport.core.data.Player
import pl.krystiankaniowski.billonsport.core.data.Rating

class TeamCalculationsTest {

	val players = listOf(
			Player("1", "p1", "p1", "p1", Rating(25f, 8.3f))
	)

	@Test
	internal fun addEvenPlayer() {

		if (players.size % 2 >= 0) {

			var avargeMean: Float = 0f
			var avargeUnconfident: Float = 0f

			for (player in players) {
				avargeMean += player.rating.mean
				avargeUnconfident += player.rating.unconfident
			}



		} else {

		}

	}

}