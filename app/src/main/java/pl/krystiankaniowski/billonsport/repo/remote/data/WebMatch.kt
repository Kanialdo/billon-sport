package pl.krystiankaniowski.billonsport.repo.remote.data

import com.google.gson.annotations.SerializedName

data class WebMatch(
		@SerializedName("_id") val id: String?,
		@SerializedName("date") val date: Long?,
		@SerializedName("teams") val teams: List<List<String>>?,
		@SerializedName("result") val result: String?)

//fun WebMatch.toMatch(): Match {
//	if (id != null && date != null && teams != null && result != null) {
//		return Match(id, date, teams[0], teams[1], result)
//	} else {
//		throw IllegalStateException()
//	}
//}