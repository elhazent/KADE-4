package com.elhazent.education.kade4.ui.fragment.next

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.elhazent.education.kade4.R
import com.elhazent.education.kade4.model.event.EventsItem
import com.elhazent.education.kade4.utils.MatchAdapter

import kotlinx.android.synthetic.main.fragment_next.*
import org.jetbrains.anko.support.v4.toast
import java.util.ArrayList


class Next(val id: String) : Fragment(),NextContract.View {

    private lateinit var adapter: MatchAdapter
    lateinit var presenter: NextPresenter

    companion object {
        const val DATA = "data"
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_next, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            presenter = NextPresenter(this)
            adapter = MatchAdapter()
            presenter.getNext(id)
        }
    }

    override fun onStart() {
        super.onStart()
        onAttachView()
    }

    override fun onDestroy() {
        super.onDestroy()
        onDettachView()
    }

    override fun getData(data: ArrayList<EventsItem>) {
        context?.let { adapter.refill(data, it) }
        recyclerview.layoutManager = LinearLayoutManager(context)
        recyclerview.adapter = adapter
    }

    override fun showMessage(message: String) {
        toast(message)
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


}
