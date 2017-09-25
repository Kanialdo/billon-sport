package pl.krystiankaniowski.billonsport.ui.login

import pl.krystiankaniowski.billonsport.mvp.BaseContract

interface LoginContract {

    interface View : BaseContract.View

    interface Presenter : BaseContract.Presenter<View>

}