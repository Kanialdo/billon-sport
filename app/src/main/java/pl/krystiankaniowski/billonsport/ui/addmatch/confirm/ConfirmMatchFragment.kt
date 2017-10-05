package pl.krystiankaniowski.billonsport.ui.addmatch.confirm

import android.view.View
import android.widget.Toast
import pl.krystiankaniowski.billonsport.R
import pl.krystiankaniowski.billonsport.di.scopes.ActivityScoped
import pl.krystiankaniowski.billonsport.ui.BaseFragment
import pl.krystiankaniowski.billonsport.ui.addmatch.ConfirmMatchContract
import javax.inject.Inject

@ActivityScoped
class ConfirmMatchFragment @Inject constructor() : BaseFragment(), ConfirmMatchContract.View {

    @Inject
    lateinit var presenter: ConfirmMatchContract.Presenter

    // ---------------------------------------------------------------------------------------------

    override fun getLayoutId(): Int = R.layout.fragment_add_match_confirm_match

    override fun prepareView(view: View) {
        Toast.makeText(context, "ConfirmMatchFragment", Toast.LENGTH_SHORT).show()
    }

    override fun dropView() {
    }

    override fun subscribePresenter() {
        presenter.takeView(this)
    }

    override fun unsubscribePresenter() {
        presenter.dropView()
    }

    // ---------------------------------------------------------------------------------------------


}