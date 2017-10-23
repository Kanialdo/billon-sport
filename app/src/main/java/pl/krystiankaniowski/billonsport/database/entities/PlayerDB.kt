package pl.krystiankaniowski.billonsport.database.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "player")
class PlayerDB() {

    constructor(id: String, nickname: String, firstName: String, lastName: String, mean: Float, standardDeviation: Float) : this() {
        this.id = id
        this.nickname = nickname
        this.firstName = firstName
        this.lastName = lastName
        this.ratingMean = mean
        this.standardDeviation = standardDeviation
    }

    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: String = ""

    @ColumnInfo(name = "nickname")
    lateinit var nickname: String

    @ColumnInfo(name = "first_name")
    lateinit var firstName: String

    @ColumnInfo(name = "last_name")
    lateinit var lastName: String

    @ColumnInfo(name = "rating_mean")
    var ratingMean: Float = -1.0f

    @ColumnInfo(name = "standardDeviation")
    var standardDeviation: Float = -1.0f


}