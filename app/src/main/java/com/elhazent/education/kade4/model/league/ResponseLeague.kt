package com.elhazent.education.kade4.model.league

import com.elhazent.education.kade4.model.league.LeaguesItem
import com.google.gson.annotations.SerializedName

data class ResponseLeague(

	@field:SerializedName("leagues")
	val leagues: List<LeaguesItem?>? = null
)