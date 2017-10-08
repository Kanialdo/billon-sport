package pl.krystiankaniowski.billonsport.mvp

import pl.krystiankaniowski.billonsport.ui.adapter.ViewElement

interface BaseListContract {

	interface View : BaseContract.View {

		fun setLoadingData()

		fun setItems(items: MutableList<out ViewElement>)

		fun updateItem(item: ViewElement, position: Int)

		fun setNoData(message: String?)

		fun setLoadingDataError(message: String?)

	}

	interface Presenter<in V : View> : BaseContract.Presenter<V>

}