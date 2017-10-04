package pl.krystiankaniowski.billonsport.ui.main

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.krystiankaniowski.billonsport.di.scopes.FragmentScoped
import pl.krystiankaniowski.billonsport.ui.main.home.EventsFragment
import pl.krystiankaniowski.billonsport.ui.main.home.HomeFragment
import pl.krystiankaniowski.billonsport.ui.main.home.ProfileFragment
import pl.krystiankaniowski.billonsport.ui.main.home.SettingsFragment
import pl.krystiankaniowski.billonsport.ui.main.players.PlayersFragment

@Module
abstract class MainActivityModule {

    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun eventsFragment(): EventsFragment

    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun homeFragment(): HomeFragment

    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun profileFragment(): ProfileFragment

    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun settingsFragment(): SettingsFragment

    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun playersFragment(): PlayersFragment

}