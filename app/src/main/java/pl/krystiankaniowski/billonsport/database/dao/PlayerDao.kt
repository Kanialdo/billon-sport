package pl.krystiankaniowski.billonsport.database.dao

import android.arch.persistence.room.*
import io.reactivex.Flowable
import pl.krystiankaniowski.billonsport.database.entities.PlayerDB

@Dao
interface PlayerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMatch(item: PlayerDB): Long

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateMatch(item: PlayerDB)

    @Delete
    fun deleteMatch(item: PlayerDB)

    @Query("SELECT * FROM match")
    fun getAll(): Flowable<List<PlayerDB>>

}