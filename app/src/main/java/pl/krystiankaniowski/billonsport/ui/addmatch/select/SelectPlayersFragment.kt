package pl.krystiankaniowski.billonsport.ui.addmatch.select

import android.view.View
import android.widget.Toast
import pl.krystiankaniowski.billonsport.R
import pl.krystiankaniowski.billonsport.di.scopes.ActivityScoped
import pl.krystiankaniowski.billonsport.ui.BaseFragment
import javax.inject.Inject

@ActivityScoped
class SelectPlayersFragment @Inject constructor() : BaseFragment(), SelectPlayersContract.View {

    @Inject
    internal lateinit var presenter: SelectPlayersContract.Presenter

    // ---------------------------------------------------------------------------------------------

    override fun getLayoutId(): Int = R.layout.fragment_add_match_select_players

    override fun prepareView(view: View) {
        Toast.makeText(context, "SelectPlayersFragment", Toast.LENGTH_SHORT).show()
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