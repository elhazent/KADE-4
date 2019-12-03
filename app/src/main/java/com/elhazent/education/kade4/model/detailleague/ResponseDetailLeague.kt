package com.elhazent.education.kade4.model.detailleague

import com.elhazent.education.kade4.model.detailleague.LeaguesItemDetail
import com.google.gson.annotations.SerializedName

data class ResponseDetailLeague(

	@field:SerializedName("leagues")
	val leagues: List<LeaguesItemDetail?>? = null
)