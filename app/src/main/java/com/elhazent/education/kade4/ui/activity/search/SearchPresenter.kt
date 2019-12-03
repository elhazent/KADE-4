package com.elhazent.education.kade4.ui.activity.search

import com.elhazent.education.kade4.base.BasePresenter
import com.elhazent.education.kade4.model.search.EventItemSearch
import com.elhazent.education.kade4.model.search.ResponseSearch
import com.elhazent.education.kade4.network.InitRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchPresenter(var view:SearchContract.View?):BasePresenter<SearchContract.View>,SearchContract.Presenter{
    override fun onAttach(view: SearchContract.View) {
        this.view = view
    }

    override fun onDettach() {
        this.view = null
    }

    override fun getSearch(query: String) {
        InitRetrofit.providerApiService().getSearchEvent(query)
            .enqueue(object : Callback<ResponseSearch> {
                override fun onFailure(call: Call<ResponseSearch>, t: Throwable) {
                }

                override fun onResponse(
                    call: Call<ResponseSearch>,
                    response: Response<ResponseSearch>
                ) {
                    if (response.isSuccessful){
                        val result = response.body()?.event
                        view?.getData(result as ArrayList<EventItemSearch>)
                    }
                }
            })
    }

}