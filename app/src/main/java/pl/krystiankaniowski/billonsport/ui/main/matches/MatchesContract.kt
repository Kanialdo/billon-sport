package pl.krystiankaniowski.billonsport.ui.main.matches

import pl.krystiankaniowski.billonsport.mvp.BaseListContract
import pl.krystiankaniowski.billonsport.ui.data.MatchUI

interface MatchesContract {

	interface View : BaseListContract.View {

		fun showAddMatchView()

		fun showMatchDetailsView(id: String)

	}

	interface Presenter : BaseListContract.Presenter<View> {

		fun addButtonClicked()

		fun click(item: MatchUI)

	}

}