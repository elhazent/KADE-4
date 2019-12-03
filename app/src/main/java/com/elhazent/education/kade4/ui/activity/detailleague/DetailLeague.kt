package com.elhazent.education.kade4.ui.activity.detailleague

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail_league.*
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.elhazent.education.kade4.R
import com.elhazent.education.kade4.model.detailleague.LeaguesItemDetail
import com.elhazent.education.kade4.ui.fragment.descleague.DescLeague
import com.elhazent.education.kade4.ui.fragment.next.Next
import com.elhazent.education.kade4.ui.fragment.previous.Previous
import com.elhazent.education.kade4.utils.ViewPageAdapter


class DetailLeague : AppCompatActivity(),DetailLeagueContract.View {

    companion object {
        const val LEAGUE_NAME = "league_name"
        const val LEAGUE_ID = "league_id"
    }

    var title:String? = null
    var image:String? = null
    var desc:String? = null
    lateinit var presenter: DetailLeaguePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_league)

        val name = intent.getStringExtra(LEAGUE_NAME)
        val id = intent.getStringExtra(LEAGUE_ID)

        toolbar.title = name

        setSupportActionBar(toolbar)
        if (supportActionBar != null)
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        presenter = DetailLeaguePresenter(this)
        presenter.getLeague(id)

        Toast.makeText(this,id,Toast.LENGTH_LONG).show()

        val viewPagerAdapter = ViewPageAdapter(supportFragmentManager)
        viewPagerAdapter.addFragment(DescLeague(id),"Description")
        viewPagerAdapter.addFragment(Previous(id), "Previous Macth")
        viewPagerAdapter.addFragment(Next(id), "Next Macth")
        viewpager.setAdapter(viewPagerAdapter)
        tabLayout.setupWithViewPager(viewpager)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)

    }

    override fun getData(data: LeaguesItemDetail) {
            Glide.with(this)
                .load(data.strLogo)
                .into(img_league)
            title = data.strLeague
            image = data.strBadge
            desc = data.strDescriptionEN

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
