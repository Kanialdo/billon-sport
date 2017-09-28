package pl.krystiankaniowski.billonsport.database.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "event")
class Event {

    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Int = -1

    @ColumnInfo(name = "name")
    var name: String = ""

    @ColumnInfo(name = "date_start")
    var dateStart: Long = -1

    @ColumnInfo(name = "date_end")
    var dateEnd: Long = -1

}