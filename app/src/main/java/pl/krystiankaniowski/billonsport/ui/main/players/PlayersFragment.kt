package pl.krystiankaniowski.billonsport.ui.main.players

import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import butterknife.BindView
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import pl.krystiankaniowski.billonsport.R
import pl.krystiankaniowski.billonsport.core.converters.CoreConverters
import pl.krystiankaniowski.billonsport.database.AppDatabase
import pl.krystiankaniowski.billonsport.di.scopes.ActivityScoped
import pl.krystiankaniowski.billonsport.ui.BaseFragment
import pl.krystiankaniowski.billonsport.ui.adapter.UniversalRecyclerAdapter
import pl.krystiankaniowski.billonsport.ui.adapter.ViewElement
import pl.krystiankaniowski.billonsport.ui.adapter.ViewElementType
import pl.krystiankaniowski.billonsport.ui.adapter.delegates.PlayerDelegateAdapter
import javax.inject.Inject

@ActivityScoped
class PlayersFragment @Inject constructor() : BaseFragment() {

    private val compositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }

    private lateinit var adapter: UniversalRecyclerAdapter<ViewElement>

    @Inject
    lateinit var database: AppDatabase

    @BindView(android.R.id.list)
    internal lateinit var recyclerAdapter: RecyclerView

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

        Toast.makeText(context, "subscribe", Toast.LENGTH_SHORT).show()

        compositeDisposable.add(database.playerDao().getAll()
                .flatMap({ list ->
                    Observable.fromIterable(list)
                            .map({ item -> CoreConverters.fromPlayerDB(item) })
                            .toList()
                            .toFlowable()
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { list ->
                            Toast.makeText(context, "pop ${list.size}!", Toast.LENGTH_SHORT).show()
                            adapter.data = list
                            adapter.notifyDataSetChanged()
                        },
                        { error ->
                            Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
                        }
                ))

    }

    override fun unsubscribePresenter() {
        compositeDisposable.clear()
    }

}