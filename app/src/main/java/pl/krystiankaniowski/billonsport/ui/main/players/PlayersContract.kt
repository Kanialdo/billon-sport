package pl.krystiankaniowski.billonsport.ui.main.players

import pl.krystiankaniowski.billonsport.mvp.BaseContract
import pl.krystiankaniowski.billonsport.mvp.BaseListContract
import pl.krystiankaniowski.billonsport.ui.addmatch.select.SelectPlayersContract
import pl.krystiankaniowski.billonsport.ui.data.PlayerUI

interface PlayersContract {

    interface View : BaseListContract.View {

    }

    interface Presenter : BaseListContract.Presenter<PlayersContract.View> {

        fun refreshData()

    }

}