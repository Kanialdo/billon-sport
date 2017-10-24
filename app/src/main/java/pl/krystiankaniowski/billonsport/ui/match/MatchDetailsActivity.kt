package pl.krystiankaniowski.billonsport.ui.match

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import pl.krystiankaniowski.billonsport.R
import pl.krystiankaniowski.billonsport.ui.BaseActivty
import pl.krystiankaniowski.billonsport.utils.ActivityUtils
import javax.inject.Inject

class MatchDetailsActivity : BaseActivty() {

	@Inject
	lateinit var fragment: MatchDetailsFragment

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_login)
		setSupportActionBar(toolbar)

		var fragment: MatchDetailsFragment? = supportFragmentManager
				.findFragmentById(R.id.contentFrame) as MatchDetailsFragment?

		if (fragment == null) {
			fragment = this.fragment
			ActivityUtils.addFragmentToActivity(supportFragmentManager,
					fragment, R.id.contentFrame)

		}

	}

}
