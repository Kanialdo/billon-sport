package pl.krystiankaniowski.billonsport.ui.addmatch.configure

import pl.krystiankaniowski.billonsport.mvp.BasePresenter
import pl.krystiankaniowski.billonsport.ui.addmatch.AddMatchFlow
import javax.inject.Inject

class ConfigureRandomizerPresenter @Inject constructor() : BasePresenter<ConfigureRandomizerContract.View>(), ConfigureRandomizerContract.Presenter {

	@Inject
	lateinit var flow: AddMatchFlow

	// ---------------------------------------------------------------------------------------------

	override fun onSubscribe() {
	}

	override fun onUnsubscribe() {
	}

	// ---------------------------------------------------------------------------------------------

	override fun next(teamsCount: Int, rounds: Int, minMatchQuality: Float) {

		flow.getBundle().teamsCount = teamsCount
		flow.getBundle().rounds = rounds
		flow.getBundle().minMatchQuality = minMatchQuality

		flow.showProcessingView()

	}

	// ---------------------------------------------------------------------------------------------

}