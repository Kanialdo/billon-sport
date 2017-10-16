package pl.krystiankaniowski.billonsport.database.dao

import android.arch.persistence.room.*
import io.reactivex.Flowable
import io.reactivex.Single
import pl.krystiankaniowski.billonsport.database.entities.PlayerDB

@Dao
interface PlayerDao {

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	fun insertPlayer(item: PlayerDB): Long

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	fun insertPlayers(vararg item: PlayerDB): List<Long>

	@Update(onConflict = OnConflictStrategy.REPLACE)
	fun updatePlayer(item: PlayerDB)

	@Delete
	fun deletePlayer(item: PlayerDB)

	@Query("SELECT * FROM player WHERE id = :id")
	fun get(id: Long): Single<PlayerDB>

	@Query("SELECT * FROM player")
	fun getAll(): Flowable<List<PlayerDB>>

}