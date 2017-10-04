package pl.krystiankaniowski.billonsport.database.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "player")
class PlayerDB() {

    constructor(id: Long, name: String, mean: Float, unconfident: Float) : this() {
        this.id = id
        this.name = name
        this.ratingMean = mean
        this.ratingUnconfident = unconfident
    }

    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Long = -1

    @ColumnInfo(name = "name")
    lateinit var name: String

    @ColumnInfo(name = "rating_mean")
    var ratingMean: Float = -1.0f

    @ColumnInfo(name = "date_unconfident")
    var ratingUnconfident: Float = -1.0f


}