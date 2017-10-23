package pl.krystiankaniowski.billonsport.database.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "match_members")
class MatchMemberDB {

	@PrimaryKey(autoGenerate = true)
	@ColumnInfo(name = "id")
	var id: Long = -1

	@ColumnInfo(name = "match_id")
	var matchId: Long = -1

	@ColumnInfo(name = "player_id")
	var playerId: Long = -1

	@ColumnInfo(name = "team_no")
	var teamId: Int = -1

}