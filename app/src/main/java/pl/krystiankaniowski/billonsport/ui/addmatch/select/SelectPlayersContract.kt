package pl.krystiankaniowski.billonsport.ui.addmatch.select

import pl.krystiankaniowski.billonsport.mvp.BaseListContract
import pl.krystiankaniowski.billonsport.ui.data.PlayerUI

interface SelectPlayersContract {

	class SelectablePlayerUI(player: PlayerUI, var clicked: Boolean) :
			PlayerUI(player.id, player.nickname, player.fullName, player.ratingMean, player.ratingUnconfident)

	interface View : BaseListContract.View {

		fun setNextButtonEnable(enable: Boolean)

		fun showError(message: String)

	}

	interface Presenter : BaseListContract.Presenter<View> {

		fun onPlayerClick(player: SelectPlayersContract.SelectablePlayerUI)

		fun onNext()

	}

}