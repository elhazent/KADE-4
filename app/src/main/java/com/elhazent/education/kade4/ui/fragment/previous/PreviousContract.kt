package com.elhazent.education.kade4.ui.fragment.previous

import com.elhazent.education.kade4.base.BaseView
import com.elhazent.education.kade4.model.event.EventsItem
import java.util.ArrayList

interface PreviousContract{
    interface Presenter{
        fun getPrevious(id:String)
    }

    interface View:BaseView{
        fun getData(data: ArrayList<EventsItem>)
        fun showMessage(message:String)
        fun loading()
        fun dissLoading()
    }
}