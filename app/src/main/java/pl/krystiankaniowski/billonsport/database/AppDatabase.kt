package pl.krystiankaniowski.billonsport.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import pl.krystiankaniowski.billonsport.database.dao.MatchDao
import pl.krystiankaniowski.billonsport.database.dao.PlayerDao
import pl.krystiankaniowski.billonsport.database.entities.MatchDB
import pl.krystiankaniowski.billonsport.database.entities.MatchMemberDB
import pl.krystiankaniowski.billonsport.database.entities.PlayerDB

@Database(entities = arrayOf(MatchDB::class, PlayerDB::class, MatchMemberDB::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun eventDao(): MatchDao

    abstract fun playerDao(): PlayerDao

}