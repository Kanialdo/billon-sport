package pl.krystiankaniowski.billonsport.core.data

data class Match(
		var id: String,
		var date: Long,
		var team1: Team,
		var team2: Team,
		var result: MatchResult
)