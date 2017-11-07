package pl.krystiankaniowski.billonsport.ui.addmatch.configure

import android.view.View
import android.widget.Toast
import butterknife.OnClick
import kotlinx.android.synthetic.main.fragment_add_match_configure_randomizer.*
import pl.krystiankaniowski.billonsport.R
import pl.krystiankaniowski.billonsport.di.scopes.ActivityScoped
import pl.krystiankaniowski.billonsport.ui.BaseFragment
import pl.krystiankaniowski.billonsport.ui.addmatch.AddMatchFlow
import javax.inject.Inject

@ActivityScoped
class ConfigureRandomizerFragment @Inject constructor() : BaseFragment(), ConfigureRandomizerContract.View {

	@Inject
	lateinit var flow: AddMatchFlow

	@Inject
	lateinit var presenter: ConfigureRandomizerContract.Presenter

	// ---------------------------------------------------------------------------------------------

	override fun getLayoutId(): Int = R.layout.fragment_add_match_configure_randomizer

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

	@OnClick(R.id.b_next)
	internal fun shuffle() {
		presenter.next(et_teams_count.text.toString().toInt(), et_rounds.text.toString().toInt(), et_quality.text.toString().toFloat())
	}

}