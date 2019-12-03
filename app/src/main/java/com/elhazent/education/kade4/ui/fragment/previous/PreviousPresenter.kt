package com.elhazent.education.kade4.ui.fragment.previous

import android.util.Log
import com.elhazent.education.kade4.base.BasePresenter
import com.elhazent.education.kade4.model.event.EventsItem
import com.elhazent.education.kade4.model.event.ResponseEvent
import com.elhazent.education.kade4.network.InitRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class PreviousPresenter(var view:PreviousContract.View?):BasePresenter<PreviousContract.View>,PreviousContract.Presenter{
    override fun onAttach(view: PreviousContract.View) {
        this.view = view
    }

    override fun onDettach() {
        this.view = null
    }

    override fun getPrevious(id: String) {
        InitRetrofit.providerApiService().getPreviousLeague(id)
            .enqueue(object :
                Callback<ResponseEvent> {
                override fun onResponse(
                    call: Call<ResponseEvent>,
                    response: Response<ResponseEvent>
                ) {
                    if (response.isSuccessful()) {
                        val result = response.body()!!.events as ArrayList<EventsItem>
                        view?.getData(result)
                    }
                }

                override fun onFailure(call: Call<ResponseEvent>, t: Throwable) {
                    Log.d("error", Objects.requireNonNull<String>(t.message))
                }
            })
    }

}