package pl.krystiankaniowski.billonsport.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import pl.krystiankaniowski.billonsport.database.dao.EventDao
import pl.krystiankaniowski.billonsport.database.entities.Event

@Database(entities = arrayOf(Event::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun eventDao(): EventDao

}