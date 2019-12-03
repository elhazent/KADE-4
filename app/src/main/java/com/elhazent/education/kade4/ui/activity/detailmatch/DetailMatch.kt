package com.elhazent.education.kade4.ui.activity.detailmatch

import android.database.sqlite.SQLiteConstraintException
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_match.*
import android.view.MenuItem
import androidx.core.content.ContextCompat
import com.elhazent.education.kade4.R
import com.elhazent.education.kade4.db.database
import com.elhazent.education.kade4.model.event.EventsItem
import com.elhazent.education.kade4.model.favorite.FavoriteModel
import com.elhazent.education.kade4.model.team.TeamsItem
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.toast


class DetailMatch : AppCompatActivity(),DetailMatchContract.View {
    companion object {
        const val DATA: String = "data"
        const val ID:String = "id"
        const val IDHOME :String = "idhome"
        const val IDAWAY :String = "idaway"
    }

    lateinit var dataitem: EventsItem
    private var menuItem: Menu? = null
    private var isFavorite: Boolean = false
    lateinit var presenter: DetailMatchPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_match)
        presenter = DetailMatchPresenter(this,DetailMatchRepository())
        val id = intent.getStringExtra(ID)
        val idhome = intent.getStringExtra(IDHOME)
        val idaway = intent.getStringExtra(IDAWAY)
        presenter.getDetailLeagueId(id)
        presenter.getDetailTeamHomeId(idhome)
        presenter.getDetailTeamAwayId(idaway)


    }

    private fun bindingItem(event: EventsItem) {
        if (event.intHomeScore == null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                dateScheduleTv.setTextColor(applicationContext.getColor(R.color.colorPrimary))
            }
        }


        dateScheduleTv.text = event.dateEvent
        homeNameTv.text = event.strHomeTeam
        homeScoreTv.text = event.intHomeScore
        awayNameTv.text = event.strAwayTeam
        awayScoreTv.text = event.intAwayScore

        homeScorerTv.text = event.strHomeGoalDetails
        awayScorerTv.text = event.strAwayGoalDetails

        gkHomeTv.text = event.strHomeLineupGoalkeeper
        gkAwayTv.text = event.strAwayLineupGoalkeeper

        defHomeTv.text = event.strHomeLineupDefense
        defAwayTv.text = event.strAwayLineupDefense

        midHomeTv.text = event.strHomeLineupMidfield
        midAwayTv.text = event.strAwayLineupMidfield

        forHomeTv.text = event.strHomeLineupForward
        forAwayTv.text = event.strAwayLineupForward

        subHomeTv.text = event.strHomeLineupSubstitutes
        subAwayTv.text = event.strAwayLineupSubstitutes

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.match, menu)
        menuItem = menu
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.getItemId()) {
            R.id.action_favorite -> {
                if (isFavorite) dataitem.idEvent?.let { removeFromFavorite(it) } else addToFavorite(dataitem)
                isFavorite = !isFavorite
                setFavorite()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun addToFavorite(dataitem:EventsItem){
        try {
            database.use {
                insert(FavoriteModel.TABLE_FAVORITE,
                    FavoriteModel.EVENT_ID to dataitem.idEvent,
                    FavoriteModel.EVENT_ID to dataitem.idEvent,
                    FavoriteModel.EVENT_DATE to dataitem.dateEvent,
                    FavoriteModel.HOME_TEAM_ID to dataitem.idHomeTeam,
                    FavoriteModel.HOME_TEAM_NAME to dataitem.strHomeTeam,
                    FavoriteModel.HOME_TEAM_SCORE to dataitem.intHomeScore,
                    FavoriteModel.AWAY_TEAM_ID to dataitem.idAwayTeam,
                    FavoriteModel.AWAY_TEAM_NAME to dataitem.strAwayTeam,
                    FavoriteModel.AWAY_TEAM_SCORE to dataitem.intAwayScore)
            }
            toast("Added to Favorite")

        }catch (e: SQLiteConstraintException){
            toast(e.localizedMessage)
        }
    }

    private fun removeFromFavorite(id : String){
        try {
            database.use {
                delete(FavoriteModel.TABLE_FAVORITE, "(EVENT_ID = {id})", "id" to id)
            }

            toast("Removed From Favorite")
        } catch (e: SQLiteConstraintException){
            toast(e.localizedMessage)
        }
    }

    private fun setFavorite(){
        if (isFavorite){
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorite_black_24dp)
        }else{
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorite_border_black_24dp)
        }

    }

    private fun favoteState(id : String){
        database.use {
            val result = select(FavoriteModel.TABLE_FAVORITE).whereArgs("(EVENT_ID = {id})", "id" to id)
            val favorite = result.parseList(classParser<FavoriteModel>())
            if (!favorite.isEmpty()) isFavorite = true
            setFavorite()
        }
    }

    override fun getDataLeague(data: EventsItem) {
        dataitem = data
        bindingItem(dataitem)
        dataitem.idEvent?.let { favoteState(it) }
    }

    override fun getDataTeamHome(data: TeamsItem) {
            Glide.with(applicationContext)
                .load(data.strTeamBadge)
                .into(homeImg)

    }

    override fun getDataTeamAway(data: TeamsItem) {
        Glide.with(applicationContext)
            .load(data.strTeamBadge)
            .into(awayImg)
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
