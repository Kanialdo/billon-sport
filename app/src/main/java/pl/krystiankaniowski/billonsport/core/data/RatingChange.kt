package pl.krystiankaniowski.billonsport.core.data

data class RatingChange(
		var playerId: String,
		var matchId: String,
		var previous: Rating,
		var current: Rating,
		var type: RatingType
)