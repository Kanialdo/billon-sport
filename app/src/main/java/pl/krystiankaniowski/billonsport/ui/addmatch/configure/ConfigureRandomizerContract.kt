package pl.krystiankaniowski.billonsport.ui.addmatch.configure

import pl.krystiankaniowski.billonsport.mvp.BaseContract

interface ConfigureRandomizerContract {

	interface View : BaseContract.View {

	}

	interface Presenter : BaseContract.Presenter<View> {

		fun next(teamsCount : Int, rounds: Int, minMatchQuality: Float)

	}

}