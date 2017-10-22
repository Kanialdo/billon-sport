package pl.krystiankaniowski.billonsport.core.data

data class Player(
		var id: String,
		var nickname: String,
		var firstName: String,
		var lastName: String,
		var rating: Rating,
		val virtual: Boolean = false
)
