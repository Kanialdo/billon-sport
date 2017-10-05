package pl.krystiankaniowski.billonsport.ui.main.matches

import android.content.Intent
import android.view.View
import butterknife.OnClick
import pl.krystiankaniowski.billonsport.R
import pl.krystiankaniowski.billonsport.di.scopes.ActivityScoped
import pl.krystiankaniowski.billonsport.ui.BaseFragment
import pl.krystiankaniowski.billonsport.ui.addmatch.AddMatchActivity
import javax.inject.Inject

@ActivityScoped
class MatchesFragment @Inject constructor() : BaseFragment(), MatchesContract.View {

    @Inject
    internal lateinit var presenter: MatchesContract.Presenter

    // ---------------------------------------------------------------------------------------------

    override fun getLayoutId(): Int = R.layout.fragment_matches

    override fun prepareView(view: View) {
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

    override fun showAddMatchView() {
        startActivity(Intent(context, AddMatchActivity::class.java))
    }

    @OnClick(R.id.b_add)
    internal fun onAddButtonClicked() {
        presenter.addButtonClicked()
    }

}