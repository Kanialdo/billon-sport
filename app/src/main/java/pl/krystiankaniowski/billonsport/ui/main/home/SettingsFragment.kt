package pl.krystiankaniowski.billonsport.ui.main.home

import android.view.View
import butterknife.OnClick
import pl.krystiankaniowski.billonsport.R
import pl.krystiankaniowski.billonsport.database.AppDatabase
import pl.krystiankaniowski.billonsport.database.sample.DatabaseSample
import pl.krystiankaniowski.billonsport.di.scopes.ActivityScoped
import pl.krystiankaniowski.billonsport.ui.BaseFragment
import javax.inject.Inject

@ActivityScoped
class SettingsFragment @Inject constructor() : BaseFragment() {

	private val TAG = "SettingsFragment"

	@Inject
	lateinit var database: AppDatabase

	override fun getLayoutId(): Int = R.layout.fragment_settings

	override fun prepareView(view: View) {
	}

	override fun dropView() {
	}

	override fun subscribePresenter() {
	}

	override fun unsubscribePresenter() {
	}

	@OnClick(R.id.button)
	fun generateDataClick() {
		DatabaseSample().fillSamplePlayers(database)
	}

}