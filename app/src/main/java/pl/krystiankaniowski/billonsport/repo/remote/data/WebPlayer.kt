package pl.krystiankaniowski.billonsport.repo.remote.data

import com.google.gson.annotations.SerializedName

data class WebPlayer(
		@SerializedName("_id") val id: String?,
		@SerializedName("nickname") val nickname: String?,
		@SerializedName("first_name") val firstName: String?,
		@SerializedName("last_name") val lastName: String?,
		@SerializedName("rank") val rating: Float?,
		@SerializedName("rank_x") val ratingSigma: Float?
)
