package pl.krystiankaniowski.billonsport.database.dao

import android.arch.persistence.room.*
import io.reactivex.Flowable
import pl.krystiankaniowski.billonsport.database.entities.MatchDB
import pl.krystiankaniowski.billonsport.database.entities.PlayerDB

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

	@Query("SELECT player.*, match_members.team_no FROM match_members LEFT JOIN player ON match_members.player_id = player.id WHERE match_members.match_id = :matchId")
	fun getMatchPlayers(matchId: String): Flowable<List<PlayerDBWithTeam>>

}

class PlayerDBWithTeam {

	@Embedded
	lateinit var player: PlayerDB

	@ColumnInfo(name = "team_no")
	var team: Int = -1

}