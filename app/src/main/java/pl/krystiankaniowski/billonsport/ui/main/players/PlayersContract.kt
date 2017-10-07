package pl.krystiankaniowski.billonsport.ui.main.players

import pl.krystiankaniowski.billonsport.mvp.BaseContract
import pl.krystiankaniowski.billonsport.ui.data.PlayerUI

interface PlayersContract {

    interface View : BaseContract.View {

        fun setLoading()

        fun setItems(items: List<PlayerUI>)

        fun setNoData(message: String?)

        fun setError(message: String?)

    }

    interface Presenter : BaseContract.Presenter<View> {

        fun refreshData()

    }

}