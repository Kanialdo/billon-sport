package pl.krystiankaniowski.billonsport.database.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import pl.krystiankaniowski.billonsport.core.data.Match
import pl.krystiankaniowski.billonsport.core.data.MatchResult
import pl.krystiankaniowski.billonsport.core.data.Team

@Entity(tableName = "match")
class MatchDB() {

	constructor(id: String, date: Long, result: MatchResult) : this() {
		this.id = id
		this.date = date
		this.result = 0
	}

	@PrimaryKey
	@ColumnInfo(name = "id")
	lateinit var id: String

	@ColumnInfo(name = "date")
	var date: Long = -1

	@ColumnInfo(name = "result")
	var result: Int = -1

}

fun MatchDB.toCoreMatch(): Match {
	return Match(this.id, this.date, Team(setOf()), Team(setOf()), MatchResult.UNKNOWN)
}