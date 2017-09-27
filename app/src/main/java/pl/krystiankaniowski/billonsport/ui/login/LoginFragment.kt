package pl.krystiankaniowski.billonsport.ui.login

import android.app.ProgressDialog
import android.view.View
import android.widget.Button
import android.widget.EditText
import butterknife.BindView
import butterknife.OnClick
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.fragment_login.*
import pl.krystiankaniowski.billonsport.R
import pl.krystiankaniowski.billonsport.di.scopes.ActivityScoped
import pl.krystiankaniowski.billonsport.ui.BaseFragment
import pl.krystiankaniowski.billonsport.utils.UiFieldSet
import javax.inject.Inject

@ActivityScoped
class LoginFragment @Inject constructor() : BaseFragment(), LoginContract.View {

    private val compositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }
    private var progressDialog: ProgressDialog? = null

    @Inject
    internal lateinit var presenter: LoginContract.Presenter

    @BindView(R.id.et_login)
    internal lateinit var etLogin: EditText

    @BindView(R.id.et_password)
    internal lateinit var etPassword: EditText

    @BindView(R.id.b_login)
    internal lateinit var bLogin: Button

    // ---------------------------------------------------------------------------------------------

    override fun getLayoutId(): Int = R.layout.fragment_login

    override fun prepareView(view: View) {
        compositeDisposable.add(RxTextView.textChanges(etLogin).subscribe({ v -> presenter.validateLogin(v.toString()) }))
        compositeDisposable.add(RxTextView.textChanges(etPassword).subscribe({ v -> presenter.validatePassword(v.toString()) }))
    }

    override fun dropView() {
        compositeDisposable.clear()
    }

    override fun subscribePresenter() {
        presenter.takeView(this)
    }

    override fun unsubscribePresenter() {
        presenter.dropView()
    }

    // ---------------------------------------------------------------------------------------------

    override fun setLoginField(enable: Boolean, value: UiFieldSet<String>) {
        etLogin.isEnabled = enable
        etLogin.setText(value.value())
    }

    override fun setPasswordField(enable: Boolean, value: UiFieldSet<String>) {
        etPassword.isEnabled = enable
        etPassword.setText(value.value())
    }

    override fun setLoginButtonEnable(enable: Boolean) {
        bLogin.isEnabled = enable
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

    // ---------------------------------------------------------------------------------------------

    @OnClick(R.id.b_login)
    internal fun click() {
        presenter.login(et_login.text.toString(), et_password.text.toString())
    }

}