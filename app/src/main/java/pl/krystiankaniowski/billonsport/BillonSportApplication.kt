package pl.krystiankaniowski.billonsport

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import pl.krystiankaniowski.billonsport.di.DaggerAppComponent
import javax.inject.Inject

class BillonSportApplication : Application(), HasActivityInjector {

	@Inject
	lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

	override fun onCreate() {
		super.onCreate()
		DaggerAppComponent
				.builder()
				.application(this)
				.build()
				.inject(this)
	}

	override fun activityInjector(): AndroidInjector<Activity> = activityDispatchingAndroidInjector

	companion object {
		var temp_match_id: String? = null
	}

}