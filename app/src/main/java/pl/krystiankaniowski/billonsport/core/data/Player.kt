package pl.krystiankaniowski.billonsport.core.data

data class Player(
		var id: Long,
		var nickname: String,
		var firstName: String,
		var lastName: String,
		var rating: Rating)
