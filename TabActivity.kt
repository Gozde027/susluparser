package com.gfcomp.suslu

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v7.app.AppCompatActivity
import com.gfcomp.suslu.adapters.ViewPagerAdapter
import kotlinx.android.synthetic.main.tab_activity.*

class TabActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tab_activity)

        slidingTab.addTab(slidingTab.newTab().setText("SUSLU"))
        slidingTab.addTab(slidingTab.newTab().setText("OFF TOPIC"))
        slidingTab.addTab(slidingTab.newTab().setText("QA"))

        val pageAdapter = ViewPagerAdapter(supportFragmentManager)
        viewpager.adapter = pageAdapter
        //slidingTab.setupWithViewPager(viewpager)

        //todo burda cok dolandim
        viewpager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(slidingTab))
        slidingTab.addOnTabSelectedListener(object :
                TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab) {
                viewpager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }

        })

    }
}
