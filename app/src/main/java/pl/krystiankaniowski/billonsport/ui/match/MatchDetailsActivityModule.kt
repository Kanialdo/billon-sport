package pl.krystiankaniowski.billonsport.ui.match

import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.krystiankaniowski.billonsport.di.scopes.ActivityScoped
import pl.krystiankaniowski.billonsport.di.scopes.FragmentScoped

@Module
abstract class MatchDetailsActivityModule {

	@FragmentScoped
	@ContributesAndroidInjector
	internal abstract fun matchDetailsFragment(): MatchDetailsFragment

	@ActivityScoped
	@Binds
	internal abstract fun matchDetailsPresenter(presenter: MatchDetailsPresenter): MatchDetailsContract.Presenter

}