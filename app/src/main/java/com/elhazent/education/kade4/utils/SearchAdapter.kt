package com.elhazent.education.kade4.utils;

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.elhazent.education.kade4.R
import com.elhazent.education.kade4.model.search.EventItemSearch
import com.elhazent.education.kade4.ui.activity.detailmatch.DetailMatch
import kotlinx.android.synthetic.main.item_match.view.*
import org.jetbrains.anko.startActivity

class SearchAdapter(var context: Activity) : RecyclerView.Adapter<SearchAdapter.ViewHolder>() {
    val data = ArrayList<EventItemSearch>()

    fun getListData(): ArrayList<EventItemSearch> {
        return data
    }

    fun removeItem(position: Int) {
        this.data.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, data.size)
    }

    fun setListData(listData: ArrayList<EventItemSearch>) {
        if (data.size > 0) {
            this.data.clear()
        }
        this.data.addAll(listData)
        notifyDataSetChanged()
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
        fun BindItem(data: EventItemSearch) {
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
                    DetailMatch.IDAWAY to data.idAwayTeam)
            }
        }
    }
}