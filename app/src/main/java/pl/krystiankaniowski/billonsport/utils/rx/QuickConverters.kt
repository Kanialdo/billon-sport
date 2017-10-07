package pl.krystiankaniowski.billonsport.utils.rx

import io.reactivex.Flowable
import io.reactivex.Observable

class QuickConverters {

	companion object {

		fun <From, To> convert(from: Collection<From>, function: (From) -> To): Flowable<List<To>> {
			return Observable.fromIterable(from)
					.map({ item -> function(item) })
					.toList()
					.toFlowable()
		}

	}

}