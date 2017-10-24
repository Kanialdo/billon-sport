package pl.krystiankaniowski.billonsport.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.krystiankaniowski.billonsport.di.scopes.ActivityScoped
import pl.krystiankaniowski.billonsport.ui.addmatch.AddMatchActivity
import pl.krystiankaniowski.billonsport.ui.addmatch.AddMatchActivityModule
import pl.krystiankaniowski.billonsport.ui.login.LoginActivity
import pl.krystiankaniowski.billonsport.ui.login.LoginActivityModule
import pl.krystiankaniowski.billonsport.ui.main.MainActivity
import pl.krystiankaniowski.billonsport.ui.main.MainActivityModule
import pl.krystiankaniowski.billonsport.ui.match.MatchDetailsActivity
import pl.krystiankaniowski.billonsport.ui.match.MatchDetailsActivityModule

@Module
abstract class ActivityBuilder {

    @ActivityScoped
    @ContributesAndroidInjector(modules = arrayOf(LoginActivityModule::class))
    internal abstract fun bindLoginActivity(): LoginActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
    internal abstract fun bindMainActivity(): MainActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = arrayOf(AddMatchActivityModule::class))
    internal abstract fun bindAddMatchActivity(): AddMatchActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = arrayOf(MatchDetailsActivityModule::class))
    internal abstract fun bindMatchDetailsActivity(): MatchDetailsActivity

}
