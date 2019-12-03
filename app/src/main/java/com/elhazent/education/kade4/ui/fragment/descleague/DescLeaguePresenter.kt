package com.elhazent.education.kade4.ui.fragment.descleague

import android.util.Log
import com.elhazent.education.kade4.base.BasePresenter
import com.elhazent.education.kade4.model.detailleague.LeaguesItemDetail
import com.elhazent.education.kade4.model.detailleague.ResponseDetailLeague
import com.elhazent.education.kade4.model.team.ResponseTeam
import com.elhazent.education.kade4.model.team.TeamsItem
import com.elhazent.education.kade4.network.InitRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class DescLeaguePresenter(var view:DescLeagueContract.View?):BasePresenter<DescLeagueContract.View>,DescLeagueContract.Presenter{
    override fun onAttach(view: DescLeagueContract.View) {
        this.view = view
    }

    override fun onDettach() {
        this.view = null
    }

    override fun getLeague(id: String) {
        InitRetrofit.providerApiService().getLeagueDetail(id)
            .enqueue(object : Callback<ResponseDetailLeague> {
                override fun onResponse(
                    call: Call<ResponseDetailLeague>,
                    response: Response<ResponseDetailLeague>
                ) {
                    if (response.isSuccessful()) {
                        for (i in 0 until response.body()?.leagues?.size!!) {
                            val responseTeam = response.body()!!.leagues?.get(i)
                            if (responseTeam?.idLeague == id) {
                                val course = LeaguesItemDetail(
                                    responseTeam.strDescriptionES,
                                    responseTeam.dateFirstEvent,
                                    responseTeam.intFormedYear,
                                    responseTeam.strBanner,
                                    responseTeam.strSport,
                                    responseTeam.strDescriptionIT,
                                    responseTeam.strDescriptionCN,
                                    responseTeam.strDescriptionEN,
                                    responseTeam.strWebsite,
                                    responseTeam.strYoutube,
                                    responseTeam.strDescriptionIL,
                                    responseTeam.idCup,
                                    responseTeam.strComplete,
                                    responseTeam.strLocked,
                                    responseTeam.idLeague,
                                    responseTeam.idSoccerXML,
                                    responseTeam.strTrophy,
                                    responseTeam.strBadge,
                                    responseTeam.strTwitter,
                                    responseTeam.strDescriptionHU,
                                    responseTeam.strGender,
                                    responseTeam.strLeagueAlternate,
                                    responseTeam.strDescriptionSE,
                                    responseTeam.strNaming,
                                    responseTeam.strDivision,
                                    responseTeam.strDescriptionJP,
                                    responseTeam.strFanart1,
                                    responseTeam.strDescriptionFR,
                                    responseTeam.strFanart2,
                                    responseTeam.strFanart3,
                                    responseTeam.strFacebook,
                                    responseTeam.strFanart4,
                                    responseTeam.strCountry,
                                    responseTeam.strDescriptionNL,
                                    responseTeam.strRSS,
                                    responseTeam.strDescriptionRU,
                                    responseTeam.strDescriptionPT,
                                    responseTeam.strLogo,
                                    responseTeam.strDescriptionDE,
                                    responseTeam.strDescriptionNO,
                                    responseTeam.strLeague,
                                    responseTeam.strPoster,
                                    responseTeam.strDescriptionPL
                                )
                                view?.getDataLeague(course)
                            }
                        }
                    }

                }

                override fun onFailure(call: Call<ResponseDetailLeague>, t: Throwable) {
                    Log.d("error", Objects.requireNonNull<String>(t.message))
                }
            })
    }

    override fun getAllTeam(id: String) {
        InitRetrofit.providerApiService().getAllTeam(id)
            .enqueue(object :
                Callback<ResponseTeam> {
                override fun onResponse(
                    call: Call<ResponseTeam>,
                    response: Response<ResponseTeam>
                ) {
                    if (response.isSuccessful()) {
                        val result = response.body()!!.teams as ArrayList<TeamsItem>
                        view?.getDataAllTeam(result)
                    }
                }

                override fun onFailure(call: Call<ResponseTeam>, t: Throwable) {
                    Log.d("error", Objects.requireNonNull<String>(t.message))
                }
            })
    }

}