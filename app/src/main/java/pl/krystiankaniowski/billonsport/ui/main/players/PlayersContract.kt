package pl.krystiankaniowski.billonsport.ui.main.players

import pl.krystiankaniowski.billonsport.core.data.Player
import pl.krystiankaniowski.billonsport.mvp.BaseContract

interface PlayersContract {

    interface View : BaseContract.View {

        fun setLoading()

        fun setItems(items: List<Player>)

        fun setNoData(message: String?)

        fun setError(message: String?)

    }

    interface Presenter : BaseContract.Presenter<View> {

        fun refreshData()

    }

}