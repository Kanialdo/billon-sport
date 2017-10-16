package pl.krystiankaniowski.billonsport.core.repository

import io.reactivex.Flowable
import io.reactivex.Single
import pl.krystiankaniowski.billonsport.core.repository.exceptions.RepoException

interface CommonRepository<T> {

	@Throws(RepoException::class)
	fun insert(item: T)

	@Throws(RepoException::class)
	fun update(item: T)

	@Throws(RepoException::class)
	fun delete(item: T)

	@Throws(RepoException::class)
	fun get(id: Long): Single<T>

	@Throws(RepoException::class)
	fun getAll(): Flowable<List<T>>

}