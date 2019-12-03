package com.elhazent.education.kade4.utils

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.elhazent.education.kade4.R
import com.elhazent.education.kade4.model.favorite.FavoriteModel
import com.elhazent.education.kade4.ui.activity.detailmatch.DetailMatch
import kotlinx.android.synthetic.main.item_match.view.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class FavoriteAdapter(private val favorite: ArrayList<FavoriteModel>, val context: Context) :
    RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        return FavoriteViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_match,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.BindItem(favorite[position])

        holder.itemView.setOnClickListener {
            context.toast("INI WOY ${favorite[position].intHomeScore}")
            context.startActivity<DetailMatch>(
                DetailMatch.ID to favorite[position].idEvent,
                DetailMatch.IDHOME to favorite[position].idHomeTeam,
                DetailMatch.IDAWAY to favorite[position].idAwayTeam
            )
        }

    }

    override fun getItemCount(): Int = favorite.size

    class FavoriteViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        @SuppressLint("SetTextI18n")
        fun BindItem(data: FavoriteModel) {
            with(itemView) {
                tvDate.text = data.dateEvent
                tvTeam1Name.text = data.strHomeTeam
                tvTeam2Name.text = data.strAwayTeam
                tvTeam1Score.text = data.intHomeScore
                tvTeam2Score.text = data.intAwayScore


            }


        }


    }
}

