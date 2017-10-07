package pl.krystiankaniowski.billonsport.database

import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import pl.krystiankaniowski.billonsport.core.data.Player
import pl.krystiankaniowski.billonsport.core.repository.PlayersRepository
import pl.krystiankaniowski.billonsport.database.converters.DatabaseConverters

class DatabasePlayersRepository constructor(val database: AppDatabase) : PlayersRepository {

    override fun insertPlayer(item: Player): Long = database.playerDao().insertPlayer(DatabaseConverters.fromCorePlayer(item))

    override fun updatePlayer(item: Player) = database.playerDao().updatePlayer(DatabaseConverters.fromCorePlayer(item))

    override fun deletePlayer(item: Player) = database.playerDao().deletePlayer(DatabaseConverters.fromCorePlayer(item))

    override fun getAll(): Flowable<List<Player>> {
        return database.playerDao().getAll()
                .subscribeOn(Schedulers.computation())
                .flatMap({ list ->
                    Observable.fromIterable(list)
                            .map({ item -> DatabaseConverters.toCorePlayer(item) })
                            .toList()
                            .toFlowable()
                })
    }

}