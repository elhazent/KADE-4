package com.elhazent.education.kade4.model.event

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class EventsItem(

    @field:SerializedName("idEvent")
    val idEvent: String? = null,

    @field:SerializedName("idHomeTeam")
    val idHomeTeam: String? = null,

    @field:SerializedName("intHomeScore")
    val intHomeScore: String? = null,

    @field:SerializedName("dateEvent")
    val dateEvent: String? = null,

    @field:SerializedName("strAwayTeam")
    val strAwayTeam: String? = null,

    @field:SerializedName("idAwayTeam")
    val idAwayTeam: String? = null,

    @field:SerializedName("strHomeTeam")
    val strHomeTeam: String? = null,

    @field:SerializedName("intAwayScore")
    val intAwayScore: String? = null,

    @field:SerializedName("strHomeGoalDetails")
    val strHomeGoalDetails: String? = null,

    @field:SerializedName("strAwayGoalDetails")
    val strAwayGoalDetails: String? = null,

    @field:SerializedName("strHomeLineupGoalkeeper")
    val strHomeLineupGoalkeeper: String? = null,

    @field:SerializedName("strAwayLineupGoalkeeper")
    val strAwayLineupGoalkeeper: String? = null,

    @field:SerializedName("strHomeLineupDefense")
    val strHomeLineupDefense: String? = null,

    @field:SerializedName("strAwayLineupDefense")
    val strAwayLineupDefense: String? = null,

    @field:SerializedName("strHomeLineupMidfield")
    val strHomeLineupMidfield: String? = null,

    @field:SerializedName("strAwayLineupMidfield")
    val strAwayLineupMidfield: String? = null,

    @field:SerializedName("strHomeLineupForward")
    val strHomeLineupForward: String? = null,

    @field:SerializedName("strAwayLineupForward")
    val strAwayLineupForward: String? = null,

    @field:SerializedName("strHomeLineupSubstitutes")
    val strHomeLineupSubstitutes: String? = null,

    @field:SerializedName("strAwayLineupSubstitutes")
    val strAwayLineupSubstitutes: String? = null

    ) : Parcelable {


}