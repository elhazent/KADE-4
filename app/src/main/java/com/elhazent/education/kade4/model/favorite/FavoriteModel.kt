package com.elhazent.education.kade4.model.favorite

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class FavoriteModel(

    val id: Long?,

    val idEvent: String? = null,

    val idHomeTeam: String? = null,

    val idAwayTeam: String? = null,

    val intHomeScore: String? = null,

    val intAwayScore: String? = null,

    val strAwayTeam: String? = null,

    val strHomeTeam: String? = null,

    val dateEvent: String? = null


) : Parcelable {
    companion object {
        const val TABLE_FAVORITE: String = "TABLE_FAVORITE"
        const val ID = "ID_"
        const val EVENT_ID = "EVENT_ID"
        const val AWAY_TEAM_ID = "AWAY_TEAM_ID"
        const val HOME_TEAM_ID = "HOME_TEAM_ID"
        const val HOME_TEAM_SCORE = "HOME_TEAM_SCORE"
        const val AWAY_TEAM_SCORE = "AWAY_TEAM_SCORE"
        const val HOME_TEAM_NAME = "HOME_TEAM_NAME"
        const val AWAY_TEAM_NAME = "AWAY_TEAM_NAME"
        const val EVENT_DATE = "EVENT_DATE"


    }
}