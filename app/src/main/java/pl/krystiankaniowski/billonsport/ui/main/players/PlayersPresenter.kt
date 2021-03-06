package pl.krystiankaniowski.billonsport.ui.main.players

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import pl.krystiankaniowski.billonsport.core.repository.Repository
import pl.krystiankaniowski.billonsport.mvp.BasePresenter
import pl.krystiankaniowski.billonsport.ui.data.PlayerUI
import pl.krystiankaniowski.billonsport.utils.rx.QuickConverters
import javax.inject.Inject

class PlayersPresenter @Inject constructor() : BasePresenter<PlayersContract.View>(), PlayersContract.Presenter {

	@Inject
	lateinit var repository: Repository

	private val compositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }

	// ---------------------------------------------------------------------------------------------

	override fun onSubscribe() {

		compositeDisposable.add(repository.getPlayers().getAll()
				.flatMap({ list -> QuickConverters.convert(list, { item -> PlayerUI.fromPlayer(item) }) })
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(
						{ list -> view?.setItems(list.toMutableList()) },
						{ error -> view?.setLoadingDataError(error.message) }
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