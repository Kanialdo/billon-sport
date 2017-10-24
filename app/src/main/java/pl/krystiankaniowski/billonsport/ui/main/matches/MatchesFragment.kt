package pl.krystiankaniowski.billonsport.ui.main.matches

import android.content.Intent
import butterknife.OnClick
import pl.krystiankaniowski.billonsport.BillonSportApplication
import pl.krystiankaniowski.billonsport.R
import pl.krystiankaniowski.billonsport.di.scopes.ActivityScoped
import pl.krystiankaniowski.billonsport.ui.adapter.UniversalRecyclerAdapter
import pl.krystiankaniowski.billonsport.ui.adapter.ViewElement
import pl.krystiankaniowski.billonsport.ui.adapter.ViewElementType
import pl.krystiankaniowski.billonsport.ui.adapter.delegates.MatchDelegateAdapter
import pl.krystiankaniowski.billonsport.ui.addmatch.AddMatchActivity
import pl.krystiankaniowski.billonsport.ui.base.BaseListFragment
import pl.krystiankaniowski.billonsport.ui.match.MatchDetailsActivity
import javax.inject.Inject

@ActivityScoped
class MatchesFragment @Inject constructor() : BaseListFragment(), MatchesContract.View {

	@Inject
	internal lateinit var presenter: MatchesContract.Presenter

	// ---------------------------------------------------------------------------------------------

	override fun getLayoutId(): Int = R.layout.fragment_matches

	override fun subscribePresenter() {
		presenter.takeView(this)
	}

	override fun unsubscribePresenter() {
		presenter.dropView()
	}

	override fun registerAdapters(builder: UniversalRecyclerAdapter.Builder<ViewElement>): UniversalRecyclerAdapter.Builder<ViewElement> {
		return builder.registerDelegatedAdapter(ViewElementType.MATCH_ITEM.ordinal, MatchDelegateAdapter({presenter.click(it)}))
	}

	// ---------------------------------------------------------------------------------------------

	override fun showAddMatchView() {
		startActivity(Intent(context, AddMatchActivity::class.java))
	}

	override fun showMatchDetailsView(id: String) {
		BillonSportApplication.temp_match_id = id
		startActivity(Intent(context, MatchDetailsActivity::class.java))
	}

	@OnClick(R.id.b_add)
	internal fun onAddButtonClicked() {
		presenter.addButtonClicked()
	}

}