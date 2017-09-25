package pl.krystiankaniowski.billonsport.di

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import pl.krystiankaniowski.billonsport.BillonSportApplication
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityBuilder::class
))
interface AppComponent : AndroidInjector<BillonSportApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<BillonSportApplication>()

}