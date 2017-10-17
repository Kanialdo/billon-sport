package pl.krystiankaniowski.billonsport.ui.addmatch.processing

import pl.krystiankaniowski.billonsport.mvp.BaseContract
import pl.krystiankaniowski.billonsport.ui.data.PlayerUI

interface ProcessingTeamsContract {

	interface View : BaseContract.View {

		fun setShufflingView(message: String)

		fun setResultView(team1: List<PlayerUI>, team2: List<PlayerUI>, qualityMessage: String)

		fun setErrorView(message: String?)

		fun setShufflingButtonEnable(enable: Boolean)

		fun setCreateButtonEnable(enable: Boolean)

	}

	interface Presenter : BaseContract.Presenter<View> {

		fun shuffleButtonClicked()

		fun createMatchButtonClicked()

	}

}