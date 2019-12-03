package com.elhazent.education.kade4.ui.fragment.descleague


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.elhazent.education.kade4.R
import com.elhazent.education.kade4.model.detailleague.LeaguesItemDetail
import com.elhazent.education.kade4.model.team.TeamsItem
import com.elhazent.education.kade4.utils.TeamAdapter
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_desc_league.*
import java.util.*


/**
 * A simple [Fragment] subclass.
 */
class DescLeague(
    var idLeague: String?
) : Fragment(), DescLeagueContract.View {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_desc_league, container, false)
    }

    private lateinit var adapter: TeamAdapter
    lateinit var presenter: DescLeaguePresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = DescLeaguePresenter(this)
        adapter = TeamAdapter()
        idLeague?.let { presenter.getLeague(it) }
        idLeague?.let { presenter.getAllTeam(it) }

    }

    fun onClickWebsite(url: String, view: View) {
        try {
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse("https://$url")
            startActivity(i)
        } catch (e: Exception) {
            Snackbar.make(view, e.message ?: "", Snackbar.LENGTH_LONG)
                .setAction("CLOSE") { }
                .setActionTextColor(resources.getColor(R.color.colorPrimary))
                .show()
        }
    }

    override fun onStart() {
        super.onStart()
        onAttachView()
    }

    override fun onDestroy() {
        super.onDestroy()
        onDettachView()
    }

    override fun getDataLeague(data: LeaguesItemDetail) {
        tv_title_league.text = data.strLeague
        tv_desc_league.text = data.strDescriptionEN
        context?.applicationContext?.let {
            Glide.with(it)
                .load(data.strBadge)
                .into(iv_league)
            btn_facebook.setOnClickListener {
                data.strFacebook?.let { it1 ->
                    view?.let { it2 ->
                        onClickWebsite(
                            it1, it2
                        )
                    }
                }
            }
            btn_twitter.setOnClickListener {
                data.strTwitter?.let { it1 ->
                    view?.let { it2 ->
                        onClickWebsite(
                            it1, it2
                        )
                    }
                }
            }
            btn_website.setOnClickListener {
                data.strWebsite?.let { it1 ->
                    view?.let { it2 ->
                        onClickWebsite(
                            it1, it2
                        )
                    }
                }
            }

        }

    }

    override fun getDataAllTeam(data: ArrayList<TeamsItem>) {
        context?.let { adapter.refill(data, it) }
        recyclerview.layoutManager =
            GridLayoutManager(context, 2, GridLayoutManager.HORIZONTAL, false)
        recyclerview.adapter = adapter

    }

    override fun showMessage(message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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

}
