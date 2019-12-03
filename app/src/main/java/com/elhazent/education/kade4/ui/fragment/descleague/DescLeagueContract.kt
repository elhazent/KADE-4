package com.elhazent.education.kade4.ui.fragment.descleague

import com.elhazent.education.kade4.base.BaseView
import com.elhazent.education.kade4.model.detailleague.LeaguesItemDetail
import com.elhazent.education.kade4.model.event.EventsItem
import com.elhazent.education.kade4.model.team.TeamsItem
import java.util.ArrayList

interface DescLeagueContract{
    interface Presenter{
        fun getLeague(id:String)
        fun getAllTeam(id:String)
    }

    interface View:BaseView{
        fun getDataLeague(data: LeaguesItemDetail)
        fun getDataAllTeam(data: ArrayList<TeamsItem>)
        fun showMessage(message:String)
        fun loading()
        fun dissLoading()
    }
}