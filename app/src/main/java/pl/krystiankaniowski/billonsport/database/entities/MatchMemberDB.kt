package pl.krystiankaniowski.billonsport.database.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore

@Entity(tableName = "match_members", primaryKeys = arrayOf("match_id", "player_id"))
class MatchMemberDB() {

	@Ignore
	constructor(matchId: String, playerId: String, teamId: Int) : this() {
		this.matchId = matchId
		this.playerId = playerId
		this.teamId = teamId
	}

	@ColumnInfo(name = "match_id")
	lateinit var matchId: String

	@ColumnInfo(name = "player_id")
	lateinit var playerId: String

	@ColumnInfo(name = "team_no")
	var teamId: Int = -1

}