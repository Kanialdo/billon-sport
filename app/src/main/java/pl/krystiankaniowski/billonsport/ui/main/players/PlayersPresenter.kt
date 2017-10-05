package pl.krystiankaniowski.billonsport.ui.main.players

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import pl.krystiankaniowski.billonsport.core.repository.PlayersRepository
import pl.krystiankaniowski.billonsport.mvp.BasePresenter
import javax.inject.Inject

class PlayersPresenter @Inject constructor() : BasePresenter<PlayersContract.View>(), PlayersContract.Presenter {

    @Inject
    lateinit var playersRepository: PlayersRepository

    private val compositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }

    // ---------------------------------------------------------------------------------------------

    override fun onSubscribe() {

        compositeDisposable.add(playersRepository.getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { list -> view?.setItems(list) },
                        { error -> view?.setError(error.message) }
                ))

    }

    override fun onUnsubscribe() {
        compositeDisposable.clear()
    }

    // ---------------------------------------------------------------------------------------------

    override fun refreshData() {
        TODO("not implemented")
    }

}