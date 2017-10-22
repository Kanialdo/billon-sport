package pl.krystiankaniowski.billonsport.mock

import pl.krystiankaniowski.billonsport.core.data.Player
import pl.krystiankaniowski.billonsport.core.data.Rating

/**
 * Created by kryst on 22.10.2017.
 */

class Players {

	companion object {

		fun kania() = Player("1", "Kania", "K", "K", Rating(25f, 8.3f))
		fun konrad() = Player("3", "Kania", "K", "K", Rating(25f, 8.3f))
		fun malyKania() = Player("2", "Maly Kania", "K", "K", Rating(25f, 8.3f))

	}

}
