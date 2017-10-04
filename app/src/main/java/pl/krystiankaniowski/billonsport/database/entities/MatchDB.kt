package pl.krystiankaniowski.billonsport.database.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "match")
class MatchDB {

    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Long = -1

    @ColumnInfo(name = "quality")
    var name: String = ""

    @ColumnInfo(name = "date")
    var date: Long = -1

    @ColumnInfo(name = "team_a_id")
    var teamAid: Long = -1

    @ColumnInfo(name = "team_b_id")
    var teamBid: Long = -1

    @ColumnInfo(name = "winner")
    var winner: Int = 0

}