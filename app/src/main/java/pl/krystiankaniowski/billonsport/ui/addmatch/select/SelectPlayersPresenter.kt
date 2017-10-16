package pl.krystiankaniowski.billonsport.ui.addmatch.select

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import pl.krystiankaniowski.billonsport.core.repository.Repository
import pl.krystiankaniowski.billonsport.mvp.BasePresenter
import pl.krystiankaniowski.billonsport.ui.addmatch.AddMatchNavigator
import pl.krystiankaniowski.billonsport.ui.addmatch.select.adapter.SelectablePlayerUI
import pl.krystiankaniowski.billonsport.ui.data.PlayerUI
import pl.krystiankaniowski.billonsport.utils.rx.QuickConverters
import javax.inject.Inject

class SelectPlayersPresenter @Inject constructor() : BasePresenter<SelectPlayersContract.View>(), SelectPlayersContract.Presenter {

	@Inject
	lateinit var navigator: AddMatchNavigator

	@Inject
	lateinit var repository: Repository

	private val compositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }

	private var dataReadyToProcessing = false
	private var selectedItems: Set<SelectablePlayerUI> = HashSet()
	private lateinit var list: MutableList<SelectablePlayerUI>

	// ---------------------------------------------------------------------------------------------

	override fun onSubscribe() {

		dataReadyToProcessing = false
		view?.setNextButtonEnable(dataReadyToProcessing)

		compositeDisposable.add(repository.getPlayers().getAll()
				.flatMap({ list -> QuickConverters.convert(list, { item -> SelectablePlayerUI(PlayerUI.fromPlayer(item), false) }) })
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(
						{ list ->
							this.list = list.toMutableList()
							view?.setItems(this.list)
							view?.setNextButtonEnable(dataReadyToProcessing)
						},
						{ error ->
							view?.setLoadingDataError(error.message)
						}
				))

	}

	override fun onUnsubscribe() {
		compositeDisposable.clear()
	}

	// ---------------------------------------------------------------------------------------------

	override fun onNext() {

		if (!dataReadyToProcessing) {
			throw IllegalStateException()
		}

		when (selectedItems.size) {
			0 -> {
				view?.showError("Nie wybrano żadnego gracza")
			}
			1 -> {
				view?.showError("Z jednego gracza nie skompletujesz dwóch drużyn")
			}
			else -> {
				navigator.showProcessingView()
				TODO()
			}
		}

	}

	override fun onPlayerClick(player: SelectablePlayerUI) {
		if (!selectedItems.contains(player)) {
			selectedItems.plus(player)
			val id = findItem(player)
			player.clicked = true
			list[id] = player
			view?.updateItem(player, id)
		} else {
			selectedItems.minus(player)
			val id = findItem(player)
			player.clicked = false
			list[id] = player
			view?.updateItem(player, id)
		}

	}

	private fun findItem(searching: SelectablePlayerUI): Int {
		var i = 0
		for (item in list) {
			if (item.equals(searching)) {
				return i
			}
			i++
		}
		return -1
	}

	// ---------------------------------------------------------------------------------------------

}