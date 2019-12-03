package com.elhazent.education.kade4.model.event

import com.elhazent.education.kade4.model.event.EventsItem
import com.google.gson.annotations.SerializedName

data class ResponseEvent(

	@field:SerializedName("events")
	val events: List<EventsItem?>? = null
)