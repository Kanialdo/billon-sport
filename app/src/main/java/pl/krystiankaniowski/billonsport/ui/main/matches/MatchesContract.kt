package pl.krystiankaniowski.billonsport.ui.main.matches

import pl.krystiankaniowski.billonsport.mvp.BaseContract

interface MatchesContract {

    interface View : BaseContract.View {

        fun showAddMatchView()

    }

    interface Presenter : BaseContract.Presenter<View> {

        fun addButtonClicked()

    }

}