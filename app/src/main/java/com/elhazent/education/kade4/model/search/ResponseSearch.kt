package com.elhazent.education.kade4.model.search

import com.elhazent.education.kade4.model.search.EventItemSearch
import com.google.gson.annotations.SerializedName

data class ResponseSearch(

	@field:SerializedName("event")
	val event: List<EventItemSearch?>? = null
)