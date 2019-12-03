package com.elhazent.education.kade4.ui.activity.detailmatch

import com.elhazent.education.kade4.base.BaseView
import com.elhazent.education.kade4.model.detailleague.LeaguesItemDetail
import com.elhazent.education.kade4.model.event.EventsItem
import com.elhazent.education.kade4.model.team.TeamsItem

interface DetailMatchContract{
    interface Presenter{
        fun getDetailLeagueId(id:String)
        fun getDetailTeamHomeId(id:String)
        fun getDetailTeamAwayId(id:String)
    }
    interface View: BaseView {
        fun getDataLeague(data: EventsItem)
        fun getDataTeamHome(data: TeamsItem)
        fun getDataTeamAway(data: TeamsItem)
        fun showMessage(message:String)
        fun loading()
        fun dissLoading()
    }
}