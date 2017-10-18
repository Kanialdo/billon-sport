package pl.krystiankaniowski.billonsport.ui.adapter.items

import pl.krystiankaniowski.billonsport.ui.adapter.ViewElement
import pl.krystiankaniowski.billonsport.ui.adapter.ViewElementType

class LoadingItem(val message: String?) : ViewElement {

	override fun getViewType(): Int = ViewElementType.LOADING_ITEM.ordinal

}
