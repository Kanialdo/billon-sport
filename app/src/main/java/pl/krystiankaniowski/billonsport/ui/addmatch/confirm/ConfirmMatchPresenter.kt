package pl.krystiankaniowski.billonsport.ui.addmatch

import pl.krystiankaniowski.billonsport.mvp.BasePresenter
import javax.inject.Inject

class ConfirmMatchPresenter @Inject constructor() : BasePresenter<ConfirmMatchContract.View>(), ConfirmMatchContract.Presenter {

    @Inject
    lateinit var flow: AddMatchFlow

    // ---------------------------------------------------------------------------------------------

    override fun onSubscribe() {
    }

    override fun onUnsubscribe() {
    }

    // ---------------------------------------------------------------------------------------------

    // ---------------------------------------------------------------------------------------------


}