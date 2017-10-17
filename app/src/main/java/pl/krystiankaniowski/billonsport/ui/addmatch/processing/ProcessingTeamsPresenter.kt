package pl.krystiankaniowski.billonsport.ui.addmatch.processing

import android.util.Log
import pl.krystiankaniowski.billonsport.mvp.BasePresenter
import pl.krystiankaniowski.billonsport.ui.addmatch.AddMatchFlow
import javax.inject.Inject

class ProcessingTeamsPresenter @Inject constructor() : BasePresenter<ProcessingTeamsContract.View>(), ProcessingTeamsContract.Presenter {

	private val TAG = "ProcessingTeamsP"

	@Inject
	lateinit var flow: AddMatchFlow

	override fun onSubscribe() {
		Log.v(TAG, "Players size: ${flow.getBundle().playersIds.size}")
	}

	override fun onUnsubscribe() {
	}

}