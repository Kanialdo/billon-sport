package pl.krystiankaniowski.billonsport.database.sample

import pl.krystiankaniowski.billonsport.database.AppDatabase
import pl.krystiankaniowski.billonsport.database.entities.PlayerDB

class DatabaseSample {

    fun fillSamplePlayers(database: AppDatabase) {

        Thread {
            database.playerDao().insertPlayer(PlayerDB(1, "p1", "Player", "One", 25.0f, 8.3f))
            database.playerDao().insertPlayer(PlayerDB(2, "p2", "Player", "Two", 25.0f, 8.3f))
            database.playerDao().insertPlayer(PlayerDB(3, "p3", "Player", "Three", 25.0f, 8.3f))
            database.playerDao().insertPlayer(PlayerDB(4, "p4", "Player", "Four", 25.0f, 8.3f))
        }.start()

    }


}