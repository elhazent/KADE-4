package com.elhazent.education.kade4.ui.fragment.next

import com.elhazent.education.kade4.base.BaseView
import com.elhazent.education.kade4.model.event.EventsItem
import java.util.ArrayList

interface NextContract{
    interface Presenter{
        fun getNext(id:String)
    }
    interface View:BaseView{
        fun getData(data:ArrayList<EventsItem>)
        fun showMessage(message:String)
        fun loading()
        fun dissLoading()
    }
}