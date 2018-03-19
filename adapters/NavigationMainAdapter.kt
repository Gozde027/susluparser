package com.gfcomp.suslu.adapters

import android.support.v4.util.SparseArrayCompat
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.gfcomp.suslu.interfaces.ItemViewType
import com.gfcomp.suslu.interfaces.ItemViewTypeDelegateAdapter
import com.gfcomp.suslu.model.ListItem

/**
 * Created by Gozde Kaval on 3/12/2018.
 */
class NavigationMainAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>()  {

    private var items : ArrayList<ItemViewType>
    private var delegateAdapters = SparseArrayCompat<ItemViewTypeDelegateAdapter>()

    init {
        delegateAdapters.put(1,NavigationListAdapter())
        items = ArrayList()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder =
        delegateAdapters.get(viewType).onCreateViewHolder(parent)

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        delegateAdapters.get(this.items[position].getViewType()).onBindViewHolder(holder,this.items[position])
    }

    fun addListItem(itemList : ArrayList<ListItem>){
        items.addAll(itemList)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int) = items[position].getViewType()
}