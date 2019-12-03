package com.elhazent.education.kade4.utils

interface RepositoryCallback<X>{
    fun onResponseSuccess(response:X?)
    fun onResponseFailed(message:String)
}