package pl.krystiankaniowski.billonsport.ui.main.home

import android.view.View
import pl.krystiankaniowski.billonsport.R
import pl.krystiankaniowski.billonsport.di.scopes.ActivityScoped
import pl.krystiankaniowski.billonsport.ui.BaseFragment
import javax.inject.Inject

@ActivityScoped
class SettingsFragment @Inject constructor() : BaseFragment() {

    override fun getLayoutId(): Int = R.layout.fragment_settings

    override fun prepareView(view: View) {
    }

    override fun dropView() {
    }

    override fun subscribePresenter() {
    }

    override fun unsubscribePresenter() {
    }

}