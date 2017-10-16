package pl.krystiankaniowski.billonsport.di

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import pl.krystiankaniowski.billonsport.core.repository.Repository
import pl.krystiankaniowski.billonsport.database.AppDatabase
import pl.krystiankaniowski.billonsport.database.plugin.RoomRepository
import pl.krystiankaniowski.billonsport.database.sample.DatabaseSample
import javax.inject.Singleton

@Module
class AppModule {

	@Provides
	@Singleton
	fun provideContext(application: Application): Context {
		return application
	}

	@Provides
	@Singleton
	fun provideDatabase(context: Context): AppDatabase {
		val database = Room.databaseBuilder(context, AppDatabase::class.java, "database").build()
		DatabaseSample().fillSamplePlayers(database)
		return database
	}

	@Provides
	@Singleton
	fun provideRepository(database: AppDatabase): Repository {
		return RoomRepository(database)
	}

}
