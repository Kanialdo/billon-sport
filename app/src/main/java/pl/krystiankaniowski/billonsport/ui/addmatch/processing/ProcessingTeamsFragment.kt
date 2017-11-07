package pl.krystiankaniowski.billonsport.ui.addmatch.processing

import android.view.View
import butterknife.OnClick
import kotlinx.android.synthetic.main.fragment_add_match_processing_teams.*
import pl.krystiankaniowski.billonsport.R
import pl.krystiankaniowski.billonsport.ui.BaseFragment
import pl.krystiankaniowski.billonsport.ui.data.PlayerUI
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

	override fun setShufflingView(message: String) {
		view_flipper.displayedChild = view_flipper.indexOfChild(ll_loading)
		tv_loading.text = message
	}

	override fun setResultView(teams: List<List<PlayerUI>>, qualityMessage: String) {
		view_flipper.displayedChild = view_flipper.indexOfChild(ll_result)

		text.text = ""
		text2.text = ""

		for (team in teams){
			text.append(team.map { it.nickname }.toString())
			text.append("\n")
		}
		tv_quality.text = qualityMessage
	}

	override fun setErrorView(message: String?) {
		view_flipper.displayedChild = view_flipper.indexOfChild(ll_error)
		tv_error.text = message
	}

	override fun setShufflingButtonEnable(enable: Boolean) {
		b_shuffle.isEnabled = enable
	}

	override fun setCreateButtonEnable(enable: Boolean) {
		b_create.isEnabled = enable
	}

	// ---------------------------------------------------------------------------------------------

	@OnClick(R.id.b_shuffle)
	internal fun shuffle() {
		presenter.shuffleButtonClicked()
	}

	@OnClick(R.id.b_create)
	internal fun create() {
		presenter.createMatchButtonClicked()
	}

}