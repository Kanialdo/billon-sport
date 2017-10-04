package pl.krystiankaniowski.billonsport.core.data

import pl.krystiankaniowski.billonsport.ui.adapter.ViewElement
import pl.krystiankaniowski.billonsport.ui.adapter.ViewElementType

data class Player(var id: Long, var nickname: String, var firstName: String, var lastName: String, var rating: Rating) : ViewElement {

    override fun getViewType(): Int = ViewElementType.PLAYER_ITEM.ordinal

}