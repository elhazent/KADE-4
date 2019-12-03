package com.elhazent.education.kade4.model.team

import com.google.gson.annotations.SerializedName

data class ResponseTeam(

	@field:SerializedName("teams")
	val teams: List<TeamsItem?>? = null
)