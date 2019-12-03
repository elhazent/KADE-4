package com.elhazent.education.kade4.ui.fragment.favorite


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.elhazent.education.kade4.R
import com.elhazent.education.kade4.db.database
import com.elhazent.education.kade4.model.favorite.FavoriteModel
import com.elhazent.education.kade4.utils.FavoriteAdapter

import kotlinx.android.synthetic.main.fragment_favorite.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select
import org.jetbrains.anko.support.v4.toast

/**
 * A simple [Fragment] subclass.
 */
class Favorite : Fragment() {

    private lateinit var adapter: FavoriteAdapter
    private var data = ArrayList<FavoriteModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    private fun showFavorite() {
        requireContext().database.use {
            val result = select(FavoriteModel.TABLE_FAVORITE)
            val match = result.parseList(classParser<FavoriteModel>())
            data.clear()
            data.addAll(match)
            adapter.notifyDataSetChanged()
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = context?.let { FavoriteAdapter(data, it) }!!
        recyclerview.adapter = adapter
        recyclerview.layoutManager = LinearLayoutManager(context)
        print("ini ga?")
        toast(data.size.toString())
        showFavorite()

    }

    override fun onResume() {
        super.onResume()
        showFavorite()

    }


}
