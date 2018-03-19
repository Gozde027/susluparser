package com.gfcomp.suslu.adapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.gfcomp.suslu.R
import com.gfcomp.suslu.inflate
import com.gfcomp.suslu.interfaces.ItemViewType
import com.gfcomp.suslu.interfaces.ItemViewTypeDelegateAdapter
import com.gfcomp.suslu.model.ListItem
import kotlinx.android.synthetic.main.navigation_list_item.view.*

/**
 * Created by Gozde Kaval on 3/12/2018.
 */
class NavigationListAdapter : ItemViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup?): RecyclerView.ViewHolder {
        return NavigationListInfoHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, item: ItemViewType) {
        (holder as NavigationListInfoHolder).bind(item as ListItem)
    }
    inner class NavigationListInfoHolder(parent: ViewGroup?) : RecyclerView.ViewHolder(parent?.inflate(R.layout.navigation_list_item)){
        private val linkText = itemView.link_text

        fun bind(item: ListItem) {
            linkText.text = item.title
        }
    }

}