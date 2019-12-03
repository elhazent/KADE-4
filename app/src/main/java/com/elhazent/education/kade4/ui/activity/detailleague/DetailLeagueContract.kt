package com.elhazent.education.kade4.ui.activity.detailleague

import com.elhazent.education.kade4.base.BaseView
import com.elhazent.education.kade4.model.detailleague.LeaguesItemDetail
import com.elhazent.education.kade4.model.team.TeamsItem
import java.util.ArrayList

interface DetailLeagueContract{
    interface Presenter{
        fun getLeague(id:String)
    }
    interface View:BaseView{
        fun getData(data: LeaguesItemDetail)
        fun showMessage(message:String)
        fun loading()
        fun dissLoading()
    }
}