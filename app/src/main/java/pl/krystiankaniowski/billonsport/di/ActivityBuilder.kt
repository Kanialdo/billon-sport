package pl.krystiankaniowski.billonsport.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.krystiankaniowski.billonsport.di.scopes.ActivityScoped
import pl.krystiankaniowski.billonsport.ui.login.LoginActivity
import pl.krystiankaniowski.billonsport.ui.login.LoginActivityModule

@Module
abstract class ActivityBuilder {

    @ActivityScoped
    @ContributesAndroidInjector(modules = arrayOf(LoginActivityModule::class))
    internal abstract fun bindLoginActivity(): LoginActivity

}
