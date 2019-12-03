package com.elhazent.education.kade4.network

import com.elhazent.education.kade4.model.detailleague.ResponseDetailLeague
import com.elhazent.education.kade4.model.event.ResponseEvent
import com.elhazent.education.kade4.model.league.ResponseLeague
import com.elhazent.education.kade4.model.search.ResponseSearch
import com.elhazent.education.kade4.model.team.ResponseTeam
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService{
    @GET("eventspastleague.php")
    fun getPreviousLeague(
        @Query("id") id: String
    ): Call<ResponseEvent>

    @GET("all_leagues.php")
    fun getAllLeague(): Call<ResponseLeague>

    @GET("eventsnextleague.php")
    fun getNextLeague(
        @Query("id") id: String
    ): Call<ResponseEvent>

    @GET("lookupevent.php")
    fun getDetailLeague(
        @Query("id") id: String
    ): Call<ResponseEvent>

    @GET("lookup_all_teams.php")
    fun getAllTeam(
        @Query("id") id: String
    ): Call<ResponseTeam>

    @GET("lookupteam.php")
    fun getDetailTeam(
        @Query("id") id: String
    ): Call<ResponseTeam>

    @GET("searchevents.php")
    fun getSearchEvent(
        @Query("e") id: String
    ): Call<ResponseSearch>

    @GET("lookupleague.php")
    fun getLeagueDetail(
        @Query("id") id: String
    ): Call<ResponseDetailLeague>
}