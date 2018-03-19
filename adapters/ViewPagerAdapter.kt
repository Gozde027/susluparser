package com.gfcomp.suslu.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.util.SparseArrayCompat
import com.gfcomp.suslu.interfaces.TabDelegateAdapter
import com.gfcomp.suslu.interfaces.TabFragmentType
import com.gfcomp.suslu.interfaces.TabType
import com.gfcomp.suslu.interfaces.TabViewType

/**
 * Created by Gozde Kaval on 3/16/2018.
 */
class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private var delegateAdapters = SparseArrayCompat<TabDelegateAdapter>()
    private var items = ArrayList<TabViewType>()

    private var susluFragment = object : TabViewType{

        override fun getTabType(): TabType = TabType.SUSLU
        override fun getTabName(): String = "SUSLU"
    }

    private var offTopicFragment = object : TabViewType{

        override fun getTabType(): TabType = TabType.OFF_TOPIC
        override fun getTabName(): String = "KONU DIŞI"
    }

    private var qaFragment = object : TabViewType{

        override fun getTabType(): TabType = TabType.QA
        override fun getTabName(): String = "SORU-CEVAP"
    }

    init {
        delegateAdapters.put(TabFragmentType.LIST.id,TabListAdapter())
        items = ArrayList()
        items.add(susluFragment)
        items.add(offTopicFragment)
        items.add(qaFragment)
    }

    override fun getItem(position: Int): Fragment {
       return delegateAdapters.get(items[position].getViewType()).getItem(items[position].getTabType())
    }

    override fun getCount(): Int {
        return items.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return items[position].getTabName()
    }
}