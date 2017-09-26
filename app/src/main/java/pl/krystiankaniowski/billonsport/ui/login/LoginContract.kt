package pl.krystiankaniowski.billonsport.ui.login

import pl.krystiankaniowski.billonsport.mvp.BaseContract
import pl.krystiankaniowski.billonsport.utils.UiFieldSet

interface LoginContract {

    interface View : BaseContract.View {

        fun setLoginField(enable: Boolean, value: UiFieldSet<String>)

        fun setPasswordField(enable: Boolean, value: UiFieldSet<String>)

        fun setLoginButtonEnable(enable: Boolean)

        fun setProgressIndicatorVisible(visible: Boolean)

    }

    interface Presenter : BaseContract.Presenter<View> {

        fun validateLogin(value: String)

        fun validatePassword(value: String)

        fun login(login: String, password: String)

    }

}