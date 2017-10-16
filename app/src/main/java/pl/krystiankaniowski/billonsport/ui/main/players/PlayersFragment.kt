package pl.krystiankaniowski.billonsport.ui.main.players

import pl.krystiankaniowski.billonsport.R
import pl.krystiankaniowski.billonsport.di.scopes.ActivityScoped
import pl.krystiankaniowski.billonsport.ui.adapter.UniversalRecyclerAdapter
import pl.krystiankaniowski.billonsport.ui.adapter.ViewElement
import pl.krystiankaniowski.billonsport.ui.adapter.ViewElementType
import pl.krystiankaniowski.billonsport.ui.adapter.delegates.PlayerDelegateAdapter
import pl.krystiankaniowski.billonsport.ui.base.BaseListFragment
import javax.inject.Inject

@ActivityScoped
class PlayersFragment @Inject constructor() : BaseListFragment(), PlayersContract.View {

	@Inject
	internal lateinit var presenter: PlayersContract.Presenter

	// ---------------------------------------------------------------------------------------------

	override fun getLayoutId(): Int = R.layout.fragment_players

	override fun registerAdapters(builder: UniversalRecyclerAdapter.Builder<ViewElement>): UniversalRecyclerAdapter.Builder<ViewElement> {
		return builder.registerDelegatedAdapter(ViewElementType.PLAYER_ITEM.ordinal, PlayerDelegateAdapter())
	}

	override fun subscribePresenter() {
		presenter.takeView(this)
	}

	override fun unsubscribePresenter() {
		presenter.dropView()
	}

	// ---------------------------------------------------------------------------------------------

}