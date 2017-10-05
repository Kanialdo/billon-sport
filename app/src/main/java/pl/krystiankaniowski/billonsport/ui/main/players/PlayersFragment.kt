package pl.krystiankaniowski.billonsport.ui.main.players

import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import butterknife.BindView
import pl.krystiankaniowski.billonsport.R
import pl.krystiankaniowski.billonsport.core.data.Player
import pl.krystiankaniowski.billonsport.di.scopes.ActivityScoped
import pl.krystiankaniowski.billonsport.ui.BaseFragment
import pl.krystiankaniowski.billonsport.ui.adapter.UniversalRecyclerAdapter
import pl.krystiankaniowski.billonsport.ui.adapter.ViewElement
import pl.krystiankaniowski.billonsport.ui.adapter.ViewElementType
import pl.krystiankaniowski.billonsport.ui.adapter.delegates.PlayerDelegateAdapter
import javax.inject.Inject

@ActivityScoped
class PlayersFragment @Inject constructor() : BaseFragment(), PlayersContract.View {

    @Inject
    internal lateinit var presenter: PlayersContract.Presenter

    @BindView(android.R.id.list)
    internal lateinit var recyclerAdapter: RecyclerView

    private lateinit var adapter: UniversalRecyclerAdapter<ViewElement>

    // ---------------------------------------------------------------------------------------------

    override fun getLayoutId(): Int = R.layout.fragment_players

    override fun prepareView(view: View) {

        adapter = UniversalRecyclerAdapter.Builder<ViewElement>()
                .registerDelegatedAdapter(ViewElementType.PLAYER_ITEM.ordinal, PlayerDelegateAdapter())
                .build()

        recyclerAdapter.setHasFixedSize(true)
        recyclerAdapter.adapter = adapter
        recyclerAdapter.layoutManager = LinearLayoutManager(context)
        recyclerAdapter.itemAnimator = DefaultItemAnimator()

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

    override fun setLoading() {
        Toast.makeText(context, "loading", Toast.LENGTH_SHORT).show()
    }

    override fun setItems(items: List<Player>) {
        adapter.data = items
        adapter.notifyDataSetChanged()
    }

    override fun setNoData(message: String?) {
        Toast.makeText(context, "no data $message", Toast.LENGTH_SHORT).show()
    }

    override fun setError(message: String?) {
        Toast.makeText(context, "error $message", Toast.LENGTH_SHORT).show()
    }

}