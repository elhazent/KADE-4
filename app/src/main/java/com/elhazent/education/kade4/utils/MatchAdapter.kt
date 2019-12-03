package com.elhazent.education.kade4.utils;

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.elhazent.education.kade4.R
import com.elhazent.education.kade4.model.event.EventsItem
import com.elhazent.education.kade4.ui.activity.detailmatch.DetailMatch
import kotlinx.android.synthetic.main.item_match.view.*
import org.jetbrains.anko.startActivity
import java.util.ArrayList

class MatchAdapter : RecyclerView.Adapter<MatchAdapter.ViewHolder>() {

    lateinit var context: Context
    lateinit var data: ArrayList<EventsItem>

    fun refill(data: ArrayList<EventsItem>, context: Context) {
        this.context = context
        this.data = ArrayList<EventsItem>()
        this.data.clear()
        this.data.addAll(data)

        notifyDataSetChanged()
    }

    fun getRefill(): ArrayList<EventsItem> {
        return data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_match, parent, false))
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.BindItem(data[position])

    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun BindItem(data: EventsItem) {
            with(itemView) {
                tvDate.text = data.dateEvent
                tvTeam1Name.text = data.strHomeTeam
                tvTeam2Name.text = data.strAwayTeam
                tvTeam1Score.text = data.intHomeScore
                tvTeam2Score.text = data.intAwayScore

            }

            itemView.setOnClickListener {
                context.startActivity<DetailMatch>(
                    DetailMatch.ID to data.idEvent,
                    DetailMatch.IDHOME to data.idHomeTeam,
                    DetailMatch.IDAWAY to data.idAwayTeam
                )
            }
        }
    }
}