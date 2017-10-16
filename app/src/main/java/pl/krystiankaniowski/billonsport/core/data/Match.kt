package pl.krystiankaniowski.billonsport.core.data

data class Match(
		var id: Long,
		var date: Long,
		var teams: List<Team>,
		var winner: Int?
)