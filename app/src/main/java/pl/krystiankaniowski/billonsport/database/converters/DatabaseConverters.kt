package pl.krystiankaniowski.billonsport.database.converters

import pl.krystiankaniowski.billonsport.core.data.Player
import pl.krystiankaniowski.billonsport.core.data.Rating
import pl.krystiankaniowski.billonsport.database.entities.PlayerDB

class DatabaseConverters {

    companion object {

        fun toCorePlayer(player: PlayerDB) = Player(player.id, player.nickname, player.firstName, player.lastName, Rating(player.ratingMean, player.ratingUnconfident))

        fun fromCorePlayer(player: Player) = PlayerDB(player.id, player.nickname, player.firstName, player.lastName, player.rating.mean, player.rating.unconfident)

    }



}