package com.gfcomp.suslu.adapters

import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.gfcomp.suslu.R
import com.gfcomp.suslu.fragments.TabListFragment
import com.gfcomp.suslu.inflate
import com.gfcomp.suslu.interfaces.ItemViewType
import com.gfcomp.suslu.interfaces.ItemViewTypeDelegateAdapter
import com.gfcomp.suslu.interfaces.TabDelegateAdapter
import com.gfcomp.suslu.interfaces.TabType
import com.gfcomp.suslu.model.ListItem
import kotlinx.android.synthetic.main.navigation_list_item.view.*

/**
 * Created by Gozde Kaval on 3/12/2018.
 */
class TabListAdapter : TabDelegateAdapter {

    override fun getItem(tabType: TabType): Fragment {
        return TabListFragment.newInstance(tabType)
    }

}