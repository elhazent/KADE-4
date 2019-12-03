package com.elhazent.education.kade4.ui.fragment.main


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.elhazent.education.kade4.R
import com.elhazent.education.kade4.model.league.Ball
import com.elhazent.education.kade4.model.league.DataDummy
import com.elhazent.education.kade4.utils.LeagueAdapter

import kotlinx.android.synthetic.main.fragment_main.*
import java.util.ArrayList

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment() {

    private lateinit var adapter: LeagueAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = activity?.let { LeagueAdapter(it) }!!
        adapter.setListData(data())
        recyclerview.layoutManager = GridLayoutManager(context, 2)
        recyclerview.adapter = adapter
    }
    fun data(): ArrayList<Ball> {
        return DataDummy.generateDummyBall()
    }


}
