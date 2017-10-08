package pl.krystiankaniowski.billonsport.ui.addmatch

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import pl.krystiankaniowski.billonsport.R
import pl.krystiankaniowski.billonsport.ui.BaseActivty
import pl.krystiankaniowski.billonsport.ui.addmatch.confirm.ConfirmMatchFragment
import pl.krystiankaniowski.billonsport.ui.addmatch.select.SelectPlayersFragment
import pl.krystiankaniowski.billonsport.utils.ActivityUtils
import javax.inject.Inject

class AddMatchActivity : BaseActivty(), AddMatchNavigator {

    @Inject
    lateinit var fragment: SelectPlayersFragment

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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showMatchView() {
        val fragment = ConfirmMatchFragment()
        supportFragmentInjector()?.inject(fragment)
        ActivityUtils.replaceFragment(supportFragmentManager, fragment, R.id.contentFrame)
    }

}
