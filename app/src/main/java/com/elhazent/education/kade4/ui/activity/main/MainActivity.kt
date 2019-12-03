package com.elhazent.education.kade4.ui.activity.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.SearchView
import com.elhazent.education.kade4.R
import com.elhazent.education.kade4.ui.activity.search.Search
import com.elhazent.education.kade4.ui.fragment.favorite.Favorite
import com.elhazent.education.kade4.ui.fragment.main.MainFragment
import com.elhazent.education.kade4.utils.ViewPageAdapter
import kotlinx.android.synthetic.main.activity_main.tabLayout
import kotlinx.android.synthetic.main.activity_main.toolbar
import kotlinx.android.synthetic.main.activity_main.viewpager
import org.jetbrains.anko.startActivity
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        //        todo 28 : create adapter for view pager
        val viewPagerAdapter = ViewPageAdapter(supportFragmentManager)
//        todo create 3 new fragments what we need
        viewPagerAdapter.addFragment(MainFragment(), "League")
        viewPagerAdapter.addFragment(Favorite(), "Favorite")
//        todo set adapter for viewpager
        viewpager.setAdapter(viewPagerAdapter)
//        todo create/set tablayout with view pager
        tabLayout.setupWithViewPager(viewpager)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        val searchView = menu.findItem(R.id.action_search).actionView as SearchView
        searchView.queryHint = "Search Match..."
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                startActivity<Search>(
                    Search.TEAM_NAME to query
                )
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })
        return true
    }

}
