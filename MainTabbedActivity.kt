package com.gfcomp.suslu

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.gfcomp.suslu.fragments.TabListFragment
import com.gfcomp.suslu.interfaces.TabType
import kotlinx.android.synthetic.main.activity_main_tabbed.*

class MainTabbedActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_suslu -> {

                addFragment(TabListFragment.newInstance(TabType.SUSLU))
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_off_topic -> {

                addFragment(TabListFragment.newInstance(TabType.OFF_TOPIC))
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_qa -> {

                addFragment(TabListFragment.newInstance(TabType.QA))
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    fun addFragment(f: android.support.v4.app.Fragment) {
        val ft = supportFragmentManager.beginTransaction()
        ft.setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out, R.anim.abc_popup_enter, R.anim.abc_popup_exit)
        ft.replace(R.id.tab_frame, f)
        ft.addToBackStack(null)
        ft.commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_tabbed)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
