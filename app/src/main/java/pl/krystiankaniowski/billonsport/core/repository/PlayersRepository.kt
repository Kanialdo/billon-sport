package pl.krystiankaniowski.billonsport.core.repository

import io.reactivex.Flowable
import pl.krystiankaniowski.billonsport.core.data.Player

interface PlayersRepository {

    fun insertPlayer(item: Player): Long

    fun updatePlayer(item: Player)

    fun deletePlayer(item: Player)

    fun getAll(): Flowable<List<Player>>

}