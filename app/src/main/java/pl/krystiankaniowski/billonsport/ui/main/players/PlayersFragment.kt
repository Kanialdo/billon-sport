package pl.krystiankaniowski.billonsport.ui.main.players

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import butterknife.BindView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import pl.krystiankaniowski.billonsport.R
import pl.krystiankaniowski.billonsport.database.AppDatabase
import pl.krystiankaniowski.billonsport.di.scopes.ActivityScoped
import pl.krystiankaniowski.billonsport.ui.BaseFragment
import javax.inject.Inject

@ActivityScoped
class PlayersFragment @Inject constructor() : BaseFragment() {

    private val compositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }

    @Inject
    lateinit var database: AppDatabase

    @BindView(android.R.id.list)
    internal lateinit var lvList: RecyclerView

    override fun getLayoutId(): Int = R.layout.fragment_players

    override fun prepareView(view: View) {
    }

    override fun dropView() {
    }

    override fun subscribePresenter() {

        compositeDisposable.add(database.playerDao().getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { list -> Toast.makeText(context, "Wczytano ${list.size} obiektów", Toast.LENGTH_SHORT).show() })

    }

    override fun unsubscribePresenter() {
        compositeDisposable.clear()
    }

}