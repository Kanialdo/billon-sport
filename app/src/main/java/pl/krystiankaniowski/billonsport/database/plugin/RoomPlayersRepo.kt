package pl.krystiankaniowski.billonsport.database.plugin

import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import pl.krystiankaniowski.billonsport.core.data.Player
import pl.krystiankaniowski.billonsport.core.repository.providers.PlayersRepo
import pl.krystiankaniowski.billonsport.database.AppDatabase
import pl.krystiankaniowski.billonsport.database.converters.DatabaseConverters

class RoomPlayersRepo constructor(val database: AppDatabase) : PlayersRepo {

	override fun insert(item: Player) {
		database.playerDao().insertPlayer(DatabaseConverters.fromCorePlayer(item))
	}

	override fun update(item: Player) {
		database.playerDao().updatePlayer(DatabaseConverters.fromCorePlayer(item))
	}

	override fun delete(item: Player) {
		database.playerDao().deletePlayer(DatabaseConverters.fromCorePlayer(item))
	}

	override fun get(id: String): Single<Player> {
		return database.playerDao().get(id)
				.subscribeOn(Schedulers.computation())
				.map { item -> DatabaseConverters.toCorePlayer(item) }
	}

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