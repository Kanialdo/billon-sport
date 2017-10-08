package pl.krystiankaniowski.billonsport.ui.addmatch.select

import android.view.View
import android.widget.Button
import android.widget.Toast
import butterknife.BindView
import butterknife.OnClick
import pl.krystiankaniowski.billonsport.R
import pl.krystiankaniowski.billonsport.di.scopes.ActivityScoped
import pl.krystiankaniowski.billonsport.ui.adapter.UniversalRecyclerAdapter
import pl.krystiankaniowski.billonsport.ui.adapter.ViewElement
import pl.krystiankaniowski.billonsport.ui.adapter.ViewElementType
import pl.krystiankaniowski.billonsport.ui.adapter.delegates.SelectPlayerDelegateAdapter
import pl.krystiankaniowski.billonsport.ui.base.BaseListFragment
import javax.inject.Inject

@ActivityScoped
class SelectPlayersFragment @Inject constructor() : BaseListFragment(), SelectPlayersContract.View {

	@Inject
	internal lateinit var presenter: SelectPlayersContract.Presenter

	@BindView(R.id.b_next)
	lateinit var buttonNext: Button

	// ---------------------------------------------------------------------------------------------

	override fun getLayoutId(): Int = R.layout.fragment_add_match_select_players

	override fun prepareView(view: View) {
		super.prepareView(view)
	}

	override fun dropView() {
		super.dropView()
	}

	override fun subscribePresenter() {
		presenter.takeView(this)
	}

	override fun unsubscribePresenter() {
		presenter.dropView()
	}

	override fun registerAdapters(builder: UniversalRecyclerAdapter.Builder<ViewElement>): UniversalRecyclerAdapter.Builder<ViewElement> {
		return builder.registerDelegatedAdapter(ViewElementType.PLAYER_ITEM.ordinal, SelectPlayerDelegateAdapter({ item -> presenter.onPlayerClick(item) }))
	}

	// ---------------------------------------------------------------------------------------------

	override fun setNextButtonEnable(enable: Boolean) {
		buttonNext.isEnabled = enable
	}

	override fun showError(message: String) {
		Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
	}

	// ---------------------------------------------------------------------------------------------

	@OnClick(R.id.b_next)
	fun onNext() {
		presenter.onNext()
	}

}