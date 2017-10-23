package pl.krystiankaniowski.billonsport.ui.main.matches

import io.reactivex.android.schedulers.AndroidSchedulers
import pl.krystiankaniowski.billonsport.core.repository.Repository
import pl.krystiankaniowski.billonsport.mvp.BasePresenter
import pl.krystiankaniowski.billonsport.ui.data.MatchUI
import javax.inject.Inject

class MatchesPresenter @Inject constructor() : BasePresenter<MatchesContract.View>(), MatchesContract.Presenter {

    @Inject
    lateinit var repo: Repository

    override fun onSubscribe() {

        view?.setLoadingData()

        repo.getMatches().getAll()
                .map { it.map { MatchUI.fromMatch(it) } }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { list -> view?.setItems(list.toMutableList()) },
                        { error -> view?.setLoadingDataError(error.message) }
                )

    }

    override fun onUnsubscribe() {
    }

    // ---------------------------------------------------------------------------------------------

    override fun addButtonClicked() {
        view?.showAddMatchView()
    }

    override fun click(item: MatchUI) {
        view?.showMatchDetailsView(item.id)
    }

}