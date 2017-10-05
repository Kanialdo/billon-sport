package pl.krystiankaniowski.billonsport.ui.main

import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.krystiankaniowski.billonsport.di.scopes.ActivityScoped
import pl.krystiankaniowski.billonsport.di.scopes.FragmentScoped
import pl.krystiankaniowski.billonsport.ui.main.home.EventsFragment
import pl.krystiankaniowski.billonsport.ui.main.home.HomeFragment
import pl.krystiankaniowski.billonsport.ui.main.home.ProfileFragment
import pl.krystiankaniowski.billonsport.ui.main.home.SettingsFragment
import pl.krystiankaniowski.billonsport.ui.main.players.PlayersContract
import pl.krystiankaniowski.billonsport.ui.main.players.PlayersFragment
import pl.krystiankaniowski.billonsport.ui.main.players.PlayersPresenter

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

    @ActivityScoped
    @Binds
    internal abstract fun playersPresenter(presenter: PlayersPresenter): PlayersContract.Presenter

}