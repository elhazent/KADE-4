package com.elhazent.education.kade4.ui.activity.search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.elhazent.education.kade4.R
import com.elhazent.education.kade4.model.search.EventItemSearch
import com.elhazent.education.kade4.utils.SearchAdapter
import kotlinx.android.synthetic.main.activity_search.*

class Search : AppCompatActivity(),SearchContract.View {


    private lateinit var adapter: SearchAdapter
    lateinit var presenter: SearchPresenter

    companion object{
        const val TEAM_NAME = "team_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val name = intent.getStringExtra(TEAM_NAME)
        supportActionBar?.title = "Search for \" $name \""
        presenter = SearchPresenter(this)
        presenter.getSearch(name)
    }

    override fun getData(data: ArrayList<EventItemSearch>) {
        val dataFiltered = data?.filter { it.strSport == "Soccer" }
        adapter = SearchAdapter(this)
        adapter.setListData(dataFiltered as ArrayList<EventItemSearch>)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = adapter
    }

    override fun showMessage(message: String) {
    }

    override fun loading() {
    }

    override fun dissLoading() {
    }

    override fun onAttachView() {
        presenter.onAttach(this)
    }

    override fun onDettachView() {
        presenter.onDettach()
    }

    override fun onStart() {
        super.onStart()
        onAttachView()
    }

    override fun onDestroy() {
        super.onDestroy()
        onDettachView()
    }
}
