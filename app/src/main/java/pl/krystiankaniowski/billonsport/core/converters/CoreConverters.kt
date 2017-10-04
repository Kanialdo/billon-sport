package pl.krystiankaniowski.billonsport.core.converters

import pl.krystiankaniowski.billonsport.core.data.Player
import pl.krystiankaniowski.billonsport.core.data.Rating
import pl.krystiankaniowski.billonsport.database.entities.PlayerDB

class CoreConverters {

    companion object {

        fun fromPlayerDB(player: PlayerDB) = Player(player.id, player.nickname, player.firstName, player.lastName, Rating(player.ratingMean, player.ratingUnconfident))

        fun toPlayerDB(player: Player) = PlayerDB(player.id, player.nickname, player.firstName, player.lastName, player.rating.mean, player.rating.unconfident)

    }

}