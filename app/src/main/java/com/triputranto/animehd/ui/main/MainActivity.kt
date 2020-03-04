package com.triputranto.animehd.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.triputranto.animehd.R
import com.triputranto.animehd.adapter.ViewPagerAdapter
import com.triputranto.animehd.ui.main.airing.AiringFragment
import com.triputranto.animehd.ui.main.allanime.AllAnimeFragment
import com.triputranto.animehd.ui.main.upcoming.UpcomingFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewPager()
    }

    private fun setupViewPager() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.populateFragment(AllAnimeFragment(), "ALL ANIME")
        adapter.populateFragment(AiringFragment(), "AIRING")
        adapter.populateFragment(UpcomingFragment(), "UPCOMING")
        view_pager.adapter = adapter
        view_pager.offscreenPageLimit = 3
        tabs.setupWithViewPager(view_pager)
    }
}
