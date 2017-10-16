package pl.krystiankaniowski.billonsport.ui.addmatch

import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.krystiankaniowski.billonsport.di.scopes.ActivityScoped
import pl.krystiankaniowski.billonsport.di.scopes.FragmentScoped
import pl.krystiankaniowski.billonsport.ui.addmatch.confirm.ConfirmMatchFragment
import pl.krystiankaniowski.billonsport.ui.addmatch.processing.ProcessingTeamsContract
import pl.krystiankaniowski.billonsport.ui.addmatch.processing.ProcessingTeamsFragment
import pl.krystiankaniowski.billonsport.ui.addmatch.processing.ProcessingTeamsPresenter
import pl.krystiankaniowski.billonsport.ui.addmatch.select.SelectPlayersContract
import pl.krystiankaniowski.billonsport.ui.addmatch.select.SelectPlayersFragment
import pl.krystiankaniowski.billonsport.ui.addmatch.select.SelectPlayersPresenter

@Module
abstract class AddMatchActivityModule {

	@FragmentScoped
	@ContributesAndroidInjector
	internal abstract fun selectPlayersFragment(): SelectPlayersFragment

	@FragmentScoped
	@ContributesAndroidInjector
	internal abstract fun confirmMatchFragment(): ConfirmMatchFragment

	@FragmentScoped
	@ContributesAndroidInjector
	internal abstract fun processingTeamsFragment(): ProcessingTeamsFragment

	@ActivityScoped
	@Binds
	internal abstract fun navigator(activity: AddMatchActivity): AddMatchNavigator

	@ActivityScoped
	@Binds
	internal abstract fun selectPlayersPresenter(presenter: SelectPlayersPresenter): SelectPlayersContract.Presenter

	@ActivityScoped
	@Binds
	internal abstract fun confirmMatchPresenter(presenter: ConfirmMatchPresenter): ConfirmMatchContract.Presenter

	@ActivityScoped
	@Binds
	internal abstract fun processingTeamsPresenter(presenter: ProcessingTeamsPresenter): ProcessingTeamsContract.Presenter

}