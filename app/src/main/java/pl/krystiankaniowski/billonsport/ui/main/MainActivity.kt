package pl.krystiankaniowski.billonsport.ui.main

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import pl.krystiankaniowski.billonsport.R
import pl.krystiankaniowski.billonsport.ui.BaseActivty
import pl.krystiankaniowski.billonsport.ui.main.home.HomeFragment
import pl.krystiankaniowski.billonsport.ui.main.home.ProfileFragment
import pl.krystiankaniowski.billonsport.ui.main.home.SettingsFragment
import pl.krystiankaniowski.billonsport.ui.main.matches.MatchesFragment
import pl.krystiankaniowski.billonsport.ui.main.players.PlayersFragment
import pl.krystiankaniowski.billonsport.utils.ActivityUtils

class MainActivity : BaseActivty() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                val fragment = HomeFragment()
                supportFragmentInjector()?.inject(fragment)
                ActivityUtils.replaceFragment(supportFragmentManager, fragment, R.id.contentFrame)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_events -> {
                val fragment = MatchesFragment()
                supportFragmentInjector()?.inject(fragment)
                ActivityUtils.replaceFragment(supportFragmentManager, fragment, R.id.contentFrame)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile -> {
                val fragment = ProfileFragment()
                supportFragmentInjector()?.inject(fragment)
                ActivityUtils.replaceFragment(supportFragmentManager, fragment, R.id.contentFrame)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_settings -> {
                val fragment = SettingsFragment()
                supportFragmentInjector()?.inject(fragment)
                ActivityUtils.replaceFragment(supportFragmentManager, fragment, R.id.contentFrame)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_players -> {
                val fragment = PlayersFragment()
                supportFragmentInjector()?.inject(fragment)
                ActivityUtils.replaceFragment(supportFragmentManager, fragment, R.id.contentFrame)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

}
