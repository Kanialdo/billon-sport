package pl.krystiankaniowski.billonsport.ui.addmatch

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import pl.krystiankaniowski.billonsport.R
import pl.krystiankaniowski.billonsport.ui.BaseActivty
import pl.krystiankaniowski.billonsport.ui.addmatch.configure.ConfigureRandomizerFragment
import pl.krystiankaniowski.billonsport.ui.addmatch.processing.ProcessingTeamsFragment
import pl.krystiankaniowski.billonsport.ui.addmatch.select.SelectPlayersFragment
import pl.krystiankaniowski.billonsport.utils.ActivityUtils
import javax.inject.Inject

class AddMatchActivity : BaseActivty(), AddMatchFlow {

	@Inject
	lateinit var fragment: SelectPlayersFragment

	@Inject
	lateinit var addMatchBundle: AddMatchBundle

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_add_match)
		setSupportActionBar(toolbar)

		var fragment: SelectPlayersFragment? = supportFragmentManager
				.findFragmentById(R.id.contentFrame) as SelectPlayersFragment?

		if (fragment == null) {
			fragment = this.fragment
			ActivityUtils.addFragmentToActivity(supportFragmentManager,
					fragment, R.id.contentFrame)

		}

	}

	override fun showSelectPlayersView() {
		val fragment = SelectPlayersFragment()
		supportFragmentInjector()?.inject(fragment)
		ActivityUtils.replaceFragment(supportFragmentManager, fragment, R.id.contentFrame)
	}

	override fun showProcessingView() {
		val fragment = ProcessingTeamsFragment()
		supportFragmentInjector()?.inject(fragment)
		ActivityUtils.replaceFragment(supportFragmentManager, fragment, R.id.contentFrame)
	}

	override fun showConfigureView() {
		val fragment = ConfigureRandomizerFragment()
		supportFragmentInjector()?.inject(fragment)
		ActivityUtils.replaceFragment(supportFragmentManager, fragment, R.id.contentFrame)
	}

	override fun showMatchView() {
		finish()
		//val fragment = ConfirmMatchFragment()
		//supportFragmentInjector()?.inject(fragment)
		//ActivityUtils.replaceFragment(supportFragmentManager, fragment, R.id.contentFrame)
	}

	override fun getBundle(): AddMatchBundle = addMatchBundle

}
