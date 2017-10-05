package pl.krystiankaniowski.billonsport.ui.main.matches

import pl.krystiankaniowski.billonsport.mvp.BasePresenter
import javax.inject.Inject

class MatchesPresenter @Inject constructor() : BasePresenter<MatchesContract.View>(), MatchesContract.Presenter {

    override fun onSubscribe() {
    }

    override fun onUnsubscribe() {
    }

    // ---------------------------------------------------------------------------------------------

    override fun addButtonClicked() {
        view?.showAddMatchView()
    }

}