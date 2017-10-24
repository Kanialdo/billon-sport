package pl.krystiankaniowski.billonsport.database.plugin

import io.reactivex.Flowable
import io.reactivex.Single
import pl.krystiankaniowski.billonsport.core.data.RatingChange
import pl.krystiankaniowski.billonsport.core.repository.providers.RatingRepo
import pl.krystiankaniowski.billonsport.database.AppDatabase

class RoomRatingRepo constructor(val database: AppDatabase) : RatingRepo {

	override fun insert(item: RatingChange) {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}

	override fun getPlayerLifetimeRatingHistory(playerId: Long): List<RatingChange> {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}

	override fun update(item: RatingChange) {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}

	override fun delete(item: RatingChange) {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}

	override fun get(id: String): Single<RatingChange> {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}

	override fun getAll(): Flowable<List<RatingChange>> {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}

}