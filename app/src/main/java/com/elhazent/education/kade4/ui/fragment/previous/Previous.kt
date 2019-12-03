package com.elhazent.education.kade4.ui.fragment.previous


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.elhazent.education.kade4.R
import com.elhazent.education.kade4.model.event.EventsItem
import com.elhazent.education.kade4.utils.MatchAdapter

import kotlinx.android.synthetic.main.fragment_previous.*
import org.jetbrains.anko.support.v4.toast
import java.util.ArrayList

/**
 * A simple [Fragment] subclass.
 */
class Previous(val id:String) : Fragment(),PreviousContract.View {

    private lateinit var adapter: MatchAdapter
    lateinit var presenter: PreviousPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_previous, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            presenter = PreviousPresenter(this)
            adapter = MatchAdapter()
            presenter.getPrevious(id)
        }

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

    override fun onStart() {
        super.onStart()
        onAttachView()
    }

    override fun onDestroy() {
        super.onDestroy()
        onDettachView()
    }


}
