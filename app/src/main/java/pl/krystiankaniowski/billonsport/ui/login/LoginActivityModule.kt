package pl.krystiankaniowski.billonsport.ui.login

import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.krystiankaniowski.billonsport.di.scopes.ActivityScoped
import pl.krystiankaniowski.billonsport.di.scopes.FragmentScoped

@Module
abstract class LoginActivityModule {

    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun loginFragment(): LoginFragment

    @ActivityScoped
    @Binds
    internal abstract fun loginPresenter(presenter: LoginPresenter): LoginContract.Presenter

}