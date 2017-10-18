package pl.krystiankaniowski.billonsport.ui.adapter.items

import pl.krystiankaniowski.billonsport.ui.adapter.ViewElement
import pl.krystiankaniowski.billonsport.ui.adapter.ViewElementType

class MessageItem private constructor(val title: String, val description: String?) : ViewElement {

	companion object {

		fun noData(title: String = "No data", description: String?): MessageItem = noData(title, description)

		fun error(title: String = "Error", description: String?): MessageItem = noData(title, description)

	}

	override fun getViewType(): Int = ViewElementType.MESSAGE_ITEM.ordinal

}
