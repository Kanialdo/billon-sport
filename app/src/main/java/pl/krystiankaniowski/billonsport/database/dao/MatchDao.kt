package pl.krystiankaniowski.billonsport.database.dao

import android.arch.persistence.room.*
import io.reactivex.Flowable
import pl.krystiankaniowski.billonsport.database.entities.MatchDB

@Dao
interface MatchDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMatch(item: MatchDB): Long

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateMatch(item: MatchDB)

    @Delete
    fun deleteMatch(item: MatchDB)

    @Query("SELECT * FROM match")
    fun getAll(): Flowable<List<MatchDB>>

}