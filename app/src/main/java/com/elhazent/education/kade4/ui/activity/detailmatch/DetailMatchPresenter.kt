package com.elhazent.education.kade4.ui.activity.detailmatch

import android.util.Log
import com.elhazent.education.kade4.base.BasePresenter
import com.elhazent.education.kade4.model.event.EventsItem
import com.elhazent.education.kade4.model.event.ResponseEvent
import com.elhazent.education.kade4.model.team.ResponseTeam
import com.elhazent.education.kade4.model.team.TeamsItem
import com.elhazent.education.kade4.network.InitRetrofit
import com.elhazent.education.kade4.utils.RepositoryCallback
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class DetailMatchPresenter(
    var view: DetailMatchContract.View?,
    var repository: DetailMatchRepository
) :
    BasePresenter<DetailMatchContract.View>, DetailMatchContract.Presenter {
    override fun onAttach(view: DetailMatchContract.View) {
        this.view = view
    }

    override fun onDettach() {
        this.view = null
    }

    override fun getDetailLeagueId(id: String) {
        repository.getDetailMatch(id, object : RepositoryCallback<ResponseEvent> {
            override fun onResponseSuccess(response: ResponseEvent?) {
                val result = response!!.events as ArrayList<EventsItem>
                val eventId = response.events?.size
                for (i in 0 until eventId!!) {
                    val responseItem = response.events?.get(i)
                    if (responseItem?.idEvent == id) {
                        val course = EventsItem(
                            responseItem.idEvent,
                            responseItem.idHomeTeam,
                            responseItem.intHomeScore,
                            responseItem.dateEvent,
                            responseItem.strAwayTeam,
                            responseItem.idAwayTeam,
                            responseItem.strHomeTeam,
                            responseItem.intAwayScore,
                            responseItem.strHomeGoalDetails,
                            responseItem.strAwayGoalDetails,
                            responseItem.strHomeLineupGoalkeeper,
                            responseItem.strAwayLineupGoalkeeper,
                            responseItem.strHomeLineupDefense,
                            responseItem.strAwayLineupDefense,
                            responseItem.strHomeLineupMidfield,
                            responseItem.strAwayLineupMidfield,
                            responseItem.strHomeLineupForward,
                            responseItem.strAwayLineupForward,
                            responseItem.strHomeLineupSubstitutes,
                            responseItem.strAwayLineupSubstitutes
                        )
                        view?.getDataLeague(course)
                    }
                }
            }

            override fun onResponseFailed(message: String) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })
    }

    override fun getDetailTeamHomeId(id: String) {
        InitRetrofit.providerApiService().getDetailTeam(id)
            .enqueue(object :
                Callback<ResponseTeam> {
                override fun onResponse(
                    call: Call<ResponseTeam>,
                    response: Response<ResponseTeam>
                ) {
                    if (response.isSuccessful()) {
                        for (i in 0 until response.body()?.teams?.size!!) {
                            val responseTeam = response.body()!!.teams?.get(i)
                            if (responseTeam?.idTeam == id) {
                                val course = TeamsItem(
                                    responseTeam.intStadiumCapacity,
                                    responseTeam.strTeamShort,
                                    responseTeam.strSport,
                                    responseTeam.strDescriptionCN,
                                    responseTeam.strTeamJersey,
                                    responseTeam.strTeamFanart2,
                                    responseTeam.strTeamFanart3,
                                    responseTeam.strTeamFanart4,
                                    responseTeam.strStadiumDescription,
                                    responseTeam.strTeamFanart1,
                                    responseTeam.intLoved,
                                    responseTeam.idLeague,
                                    responseTeam.idSoccerXML,
                                    responseTeam.strTeamLogo,
                                    responseTeam.strDescriptionSE,
                                    responseTeam.strDescriptionJP,
                                    responseTeam.strDescriptionFR,
                                    responseTeam.strStadiumLocation,
                                    responseTeam.strDescriptionNL,
                                    responseTeam.strCountry,
                                    responseTeam.strRSS,
                                    responseTeam.strDescriptionRU,
                                    responseTeam.strTeamBanner,
                                    responseTeam.strDescriptionNO,
                                    responseTeam.strStadiumThumb,
                                    responseTeam.strDescriptionES,
                                    responseTeam.intFormedYear,
                                    responseTeam.strInstagram,
                                    responseTeam.strDescriptionIT,
                                    responseTeam.idTeam,
                                    responseTeam.strDescriptionEN,
                                    responseTeam.strWebsite,
                                    responseTeam.strYoutube,
                                    responseTeam.strDescriptionIL,
                                    responseTeam.strLocked,
                                    responseTeam.strAlternate,
                                    responseTeam.strTeam,
                                    responseTeam.strTwitter,
                                    responseTeam.strDescriptionHU,
                                    responseTeam.strGender,
                                    responseTeam.strDivision,
                                    responseTeam.strStadium,
                                    responseTeam.strFacebook,
                                    responseTeam.strTeamBadge,
                                    responseTeam.strDescriptionPT,
                                    responseTeam.strDescriptionDE,
                                    responseTeam.strLeague,
                                    responseTeam.strManager,
                                    responseTeam.strKeywords,
                                    responseTeam.strDescriptionPL
                                )
                                view?.getDataTeamHome(course)
                            }
                        }
                    }
                }

                override fun onFailure(call: Call<ResponseTeam>, t: Throwable) {
                    Log.d("error", Objects.requireNonNull<String>(t.message))
                }
            })
    }

    override fun getDetailTeamAwayId(id: String) {
        InitRetrofit.providerApiService().getDetailTeam(id)
            .enqueue(object :
                Callback<ResponseTeam> {
                override fun onResponse(
                    call: Call<ResponseTeam>,
                    response: Response<ResponseTeam>
                ) {
                    if (response.isSuccessful()) {
                        for (i in 0 until response.body()?.teams?.size!!) {
                            val responseTeam = response.body()!!.teams?.get(i)
                            if (responseTeam?.idTeam == id) {
                                val course = TeamsItem(
                                    responseTeam.intStadiumCapacity,
                                    responseTeam.strTeamShort,
                                    responseTeam.strSport,
                                    responseTeam.strDescriptionCN,
                                    responseTeam.strTeamJersey,
                                    responseTeam.strTeamFanart2,
                                    responseTeam.strTeamFanart3,
                                    responseTeam.strTeamFanart4,
                                    responseTeam.strStadiumDescription,
                                    responseTeam.strTeamFanart1,
                                    responseTeam.intLoved,
                                    responseTeam.idLeague,
                                    responseTeam.idSoccerXML,
                                    responseTeam.strTeamLogo,
                                    responseTeam.strDescriptionSE,
                                    responseTeam.strDescriptionJP,
                                    responseTeam.strDescriptionFR,
                                    responseTeam.strStadiumLocation,
                                    responseTeam.strDescriptionNL,
                                    responseTeam.strCountry,
                                    responseTeam.strRSS,
                                    responseTeam.strDescriptionRU,
                                    responseTeam.strTeamBanner,
                                    responseTeam.strDescriptionNO,
                                    responseTeam.strStadiumThumb,
                                    responseTeam.strDescriptionES,
                                    responseTeam.intFormedYear,
                                    responseTeam.strInstagram,
                                    responseTeam.strDescriptionIT,
                                    responseTeam.idTeam,
                                    responseTeam.strDescriptionEN,
                                    responseTeam.strWebsite,
                                    responseTeam.strYoutube,
                                    responseTeam.strDescriptionIL,
                                    responseTeam.strLocked,
                                    responseTeam.strAlternate,
                                    responseTeam.strTeam,
                                    responseTeam.strTwitter,
                                    responseTeam.strDescriptionHU,
                                    responseTeam.strGender,
                                    responseTeam.strDivision,
                                    responseTeam.strStadium,
                                    responseTeam.strFacebook,
                                    responseTeam.strTeamBadge,
                                    responseTeam.strDescriptionPT,
                                    responseTeam.strDescriptionDE,
                                    responseTeam.strLeague,
                                    responseTeam.strManager,
                                    responseTeam.strKeywords,
                                    responseTeam.strDescriptionPL
                                )
                                view?.getDataTeamAway(course)
                            }
                        }
                    }
                }

                override fun onFailure(call: Call<ResponseTeam>, t: Throwable) {
                    Log.d("error", Objects.requireNonNull<String>(t.message))
                }
            })
    }

}