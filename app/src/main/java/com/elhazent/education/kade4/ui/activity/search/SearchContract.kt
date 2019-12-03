package com.elhazent.education.kade4.ui.activity.search

import com.elhazent.education.kade4.base.BaseView
import com.elhazent.education.kade4.model.detailleague.LeaguesItemDetail
import com.elhazent.education.kade4.model.search.EventItemSearch

interface SearchContract{
    interface Presenter{
        fun getSearch(query:String)
    }
    interface View: BaseView {
        fun getData(data: ArrayList<EventItemSearch>)
        fun showMessage(message:String)
        fun loading()
        fun dissLoading()
    }
}