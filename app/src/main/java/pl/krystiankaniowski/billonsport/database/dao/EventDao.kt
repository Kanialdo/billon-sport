package pl.krystiankaniowski.billonsport.database.dao

import android.arch.persistence.room.*
import io.reactivex.Flowable
import pl.krystiankaniowski.billonsport.database.entities.Event

@Dao
interface EventDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTask(item: Event): Long

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateTask(item: Event)

    @Delete
    fun deleteTask(item: Event)

    @Query("SELECT * FROM event")
    fun getAll(): Flowable<List<Event>>

}