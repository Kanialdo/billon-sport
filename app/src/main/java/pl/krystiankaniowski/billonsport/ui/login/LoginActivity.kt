package pl.krystiankaniowski.billonsport.ui.login

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import pl.krystiankaniowski.billonsport.R
import pl.krystiankaniowski.billonsport.ui.BaseActivty
import pl.krystiankaniowski.billonsport.utils.ActivityUtils
import javax.inject.Inject

class LoginActivity : BaseActivty() {

    @Inject
    lateinit var fragment: LoginFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setSupportActionBar(toolbar)

        var fragment: LoginFragment? = supportFragmentManager
                .findFragmentById(R.id.contentFrame) as LoginFragment?

        if (fragment == null) {
            fragment = this.fragment
            ActivityUtils.addFragmentToActivity(supportFragmentManager,
                    fragment, R.id.contentFrame)

        }

    }

}
