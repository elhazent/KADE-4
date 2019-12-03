package com.elhazent.education.kade4.base

interface BasePresenter<X:BaseView>{
    fun onAttach(view:X)
    fun onDettach()
}