package com.elhazent.education.kade4.utils;

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.jetbrains.anko.startActivity
import com.bumptech.glide.Glide
import com.elhazent.education.kade4.R
import com.elhazent.education.kade4.model.league.Ball
import com.elhazent.education.kade4.ui.activity.detailleague.DetailLeague
import kotlinx.android.synthetic.main.list_grid.view.*


class LeagueAdapter(var context: Activity) : RecyclerView.Adapter<LeagueAdapter.ViewHolder>() {
    val data = ArrayList<Ball>()

    fun getListData(): ArrayList<Ball> {
        return data
    }

    fun removeItem(position: Int) {
        this.data.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, data.size)
    }

    fun setListData(listData: ArrayList<Ball>) {
        if (data.size > 0) {
            this.data.clear()
        }
        this.data.addAll(listData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_grid, parent, false))
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.BindItem(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun BindItem(data: Ball) {
            itemView.tv_item_title.text = data.name
            Glide.with(itemView.context)
                .load(data.image)
                .into(itemView.img_poster)
            itemView.setOnClickListener {
                context.startActivity<DetailLeague>(
                    DetailLeague.LEAGUE_ID to data.id,
                    DetailLeague.LEAGUE_NAME to data.name
                )
                            }

        }
    }
}