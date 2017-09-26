package pl.krystiankaniowski.billonsport.ui.login

import android.app.ProgressDialog
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.fragment_login.*
import pl.krystiankaniowski.billonsport.R
import pl.krystiankaniowski.billonsport.di.scopes.ActivityScoped
import pl.krystiankaniowski.billonsport.ui.BaseFragment
import pl.krystiankaniowski.billonsport.utils.UiFieldSet
import javax.inject.Inject

@ActivityScoped
class LoginFragment @Inject constructor() : BaseFragment(), LoginContract.View {

    var progressDialog: ProgressDialog? = null

    @Inject
    lateinit var presenter: LoginContract.Presenter

    // ---------------------------------------------------------------------------------------------

    override fun getLayoutId(): Int = R.layout.fragment_login

    override fun prepareView(view: View) {
        val button: Button = view.findViewById(R.id.b_login)
        button.setOnClickListener { _ -> presenter.login(et_login.text.toString(), et_password.text.toString()) }
    }

    override fun subscribePresenter() {
        presenter.takeView(this)
    }

    override fun unsubscribePresenter() {
        presenter.dropView()
    }

    // ---------------------------------------------------------------------------------------------

    override fun setLoginField(enable: Boolean, value: UiFieldSet<String>) {
        et_login.isEnabled = enable
        et_login.setText(value.value())
    }

    override fun setPasswordField(enable: Boolean, value: UiFieldSet<String>) {
        et_password.isEnabled = enable
        et_password.setText(value.value())
    }

    override fun setLoginButtonEnable(enable: Boolean) {
        b_login.isEnabled = enable
    }

    override fun setProgressIndicatorVisible(visible: Boolean) {
        if (visible) {
            progressDialog = ProgressDialog.show(context, "Login", "login pending")
            // Toast.makeText(context, "Rozpoczeto logowanie", Toast.LENGTH_SHORT).show()
        } else {
            progressDialog?.dismiss()
            progressDialog = null
        }
    }

}