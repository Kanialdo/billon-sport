package pl.krystiankaniowski.billonsport.ui.addmatch.select

import pl.krystiankaniowski.billonsport.mvp.BaseListContract
import pl.krystiankaniowski.billonsport.ui.addmatch.select.adapter.SelectablePlayerUI

interface SelectPlayersContract {

	interface View : BaseListContract.View {

		fun setNextButtonEnable(enable: Boolean)

		fun showError(message: String)

	}

	interface Presenter : BaseListContract.Presenter<View> {

		fun onPlayerClick(player: SelectablePlayerUI)

		fun onNext()

	}

}