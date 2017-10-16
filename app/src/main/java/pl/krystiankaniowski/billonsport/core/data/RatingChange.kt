package pl.krystiankaniowski.billonsport.core.data

data class RatingChange(
		var matchId: Long,
		var previous: Rating,
		var current: Rating,
		var type: RatingType
)