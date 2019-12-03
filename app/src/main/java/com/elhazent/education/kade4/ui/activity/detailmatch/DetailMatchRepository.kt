package com.elhazent.education.kade4.ui.activity.detailmatch

import android.util.Log
import com.elhazent.education.kade4.model.event.ResponseEvent
import com.elhazent.education.kade4.network.InitRetrofit
import com.elhazent.education.kade4.utils.RepositoryCallback
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList

class DetailMatchRepository{
    fun getDetailMatch(id:String,callback:RepositoryCallback<ResponseEvent>){
        InitRetrofit.providerApiService().getDetailLeague(id)
            .enqueue(object :
                Callback<ResponseEvent> {
                override fun onResponse(
                    call: Call<ResponseEvent>,
                    response: Response<ResponseEvent>
                ) {
                    if (response.isSuccessful) {
                        callback.onResponseSuccess(response.body())
                    } else {
                        callback.onResponseFailed("Error get data")
                    }
                }

                override fun onFailure(call: Call<ResponseEvent>, t: Throwable) {
                    Log.d("error", Objects.requireNonNull<String>(t.message))
                    t.message?.let { callback.onResponseFailed(it) }
                }
            })
    }
}