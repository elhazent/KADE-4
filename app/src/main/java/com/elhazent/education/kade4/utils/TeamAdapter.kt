package com.elhazent.education.kade4.utils;

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.elhazent.education.kade4.R
import com.elhazent.education.kade4.model.event.EventsItem
import com.elhazent.education.kade4.model.team.TeamsItem
import kotlinx.android.synthetic.main.list_grid.view.*
import kotlinx.android.synthetic.main.team_item.view.*
import java.util.ArrayList

class TeamAdapter: RecyclerView.Adapter<TeamAdapter.ViewHolder>() {

    lateinit var context: Context
    lateinit var data: ArrayList<TeamsItem>

    fun refill(data: ArrayList<TeamsItem>, context: Context) {
        this.context = context
        this.data = ArrayList<TeamsItem>()
        this.data.clear()
        this.data.addAll(data)

        notifyDataSetChanged()
    }

    fun getRefill(): ArrayList<TeamsItem> {
        return data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.team_item, parent, false))
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.BindItem(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun BindItem(data: TeamsItem) {
            itemView.team_name.text = data.strTeam
            Glide.with(itemView.context)
                .load(data.strTeamBadge)
                .into(itemView.team_image)
        }
    }
}