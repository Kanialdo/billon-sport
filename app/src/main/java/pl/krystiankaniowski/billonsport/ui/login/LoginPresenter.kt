package pl.krystiankaniowski.billonsport.ui.login

import pl.krystiankaniowski.billonsport.mvp.BasePresenter
import pl.krystiankaniowski.billonsport.utils.UiFieldsProvider
import javax.inject.Inject

class LoginPresenter @Inject constructor() : BasePresenter<LoginContract.View>(), LoginContract.Presenter {

    private var login: String? = null
    private var password: String? = null

    // ---------------------------------------------------------------------------------------------

    override fun onSubscribe() {
        view?.setLoginField(true, UiFieldsProvider.justOk(""))
        view?.setPasswordField(true, UiFieldsProvider.justOk(""))
        view?.setLoginButtonEnable(false)
    }

    override fun onUnsubscribe() {
    }

    // ---------------------------------------------------------------------------------------------

    override fun validateLogin(value: String) {
        login = value
        dynamicProcessForm()
    }

    override fun validatePassword(value: String) {
        password = value
        dynamicProcessForm()
    }

    override fun login(login: String, password: String) {
        view?.setLoginField(false, UiFieldsProvider.justOk(login))
        view?.setPasswordField(false, UiFieldsProvider.justOk(password))
        view?.setLoginButtonEnable(false)
        view?.setProgressIndicatorVisible(true)
    }

    // ---------------------------------------------------------------------------------------------

    private fun dynamicProcessForm() {
        view?.setLoginButtonEnable(!(login?.isEmpty() ?: true) && !(password?.isEmpty() ?: true))
    }

}