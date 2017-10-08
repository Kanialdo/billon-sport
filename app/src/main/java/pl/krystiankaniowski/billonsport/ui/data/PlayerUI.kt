package pl.krystiankaniowski.billonsport.ui.data

import pl.krystiankaniowski.billonsport.core.data.Player
import pl.krystiankaniowski.billonsport.ui.adapter.ViewElement
import pl.krystiankaniowski.billonsport.ui.adapter.ViewElementType

open class PlayerUI(
		val id: Long,
		val nickname: String,
		val fullName: String,
		val ratingMean: String,
		val ratingUnconfident: String) : ViewElement {

	companion object {

		fun fromPlayer(player: Player) = PlayerUI(player.id,
				player.nickname,
				player.firstName + " " + player.lastName,
				player.rating.mean.toString(),
				player.rating.unconfident.toString())

	}

	override fun getViewType(): Int = ViewElementType.PLAYER_ITEM.ordinal

}