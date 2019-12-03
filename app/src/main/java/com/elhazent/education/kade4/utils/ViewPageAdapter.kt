package com.elhazent.education.kade4.utils

import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import java.nio.file.Files.size
import androidx.fragment.app.FragmentPagerAdapter


internal class ViewPageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    var fragments: ArrayList<Fragment>
    var titles: ArrayList<String>

    init {
        this.fragments = ArrayList()
        this.titles = ArrayList()
    }

    //todo dua
    override fun getItem(i: Int): Fragment {
        return fragments[i]
    }

    override fun getCount(): Int {
        return fragments.size
    }

    //        todo create method for add new fragment
    fun addFragment(fragment: Fragment, title: String) {
        fragments.add(fragment)
        titles.add(title)
    }

    // todo satu
    @Nullable
    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }
}