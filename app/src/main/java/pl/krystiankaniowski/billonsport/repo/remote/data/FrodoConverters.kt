package pl.krystiankaniowski.billonsport.repo.remote.data

import pl.krystiankaniowski.billonsport.core.data.Player
import pl.krystiankaniowski.billonsport.core.data.Rating

fun WebPlayer.toPlayer(): Player {
	if (id != null && nickname != null && firstName != null && lastName != null && rating != null && ratingSigma != null) {
		return Player(id, nickname, firstName, lastName, Rating(rating, ratingSigma))
	} else {
		throw IllegalStateException()
	}
}