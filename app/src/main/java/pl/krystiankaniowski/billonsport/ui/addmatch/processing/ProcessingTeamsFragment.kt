package pl.krystiankaniowski.billonsport.ui.addmatch.processing

import android.view.View
import pl.krystiankaniowski.billonsport.R
import pl.krystiankaniowski.billonsport.ui.BaseFragment
import javax.inject.Inject

class ProcessingTeamsFragment @Inject constructor() : BaseFragment(), ProcessingTeamsContract.View {

	@Inject
	internal lateinit var presenter: ProcessingTeamsContract.Presenter

	override fun getLayoutId(): Int = R.layout.fragment_add_match_processing_teams

	override fun prepareView(view: View) {
	}

	override fun dropView() {
	}

	override fun subscribePresenter() {
		presenter.takeView(this)
	}

	override fun unsubscribePresenter() {
		presenter.dropView()
	}

	// ---------------------------------------------------------------------------------------------

}