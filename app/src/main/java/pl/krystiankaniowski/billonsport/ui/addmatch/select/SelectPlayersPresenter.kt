package pl.krystiankaniowski.billonsport.ui.addmatch.select

import pl.krystiankaniowski.billonsport.mvp.BasePresenter
import pl.krystiankaniowski.billonsport.ui.addmatch.AddMatchNavigator
import javax.inject.Inject

class SelectPlayersPresenter @Inject constructor() : BasePresenter<SelectPlayersContract.View>(), SelectPlayersContract.Presenter {

    @Inject
    lateinit var navigator: AddMatchNavigator

    // ---------------------------------------------------------------------------------------------

    override fun onSubscribe() {
        navigator.showConfirmationView()
    }

    override fun onUnsubscribe() {
    }

    // ---------------------------------------------------------------------------------------------

    // ---------------------------------------------------------------------------------------------

}