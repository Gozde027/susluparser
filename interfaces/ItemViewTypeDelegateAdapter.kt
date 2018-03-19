package com.gfcomp.suslu.interfaces

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
 * Created by Gozde Kaval on 3/12/2018.
 */
interface ItemViewTypeDelegateAdapter {
    fun onCreateViewHolder(parent: ViewGroup?): RecyclerView.ViewHolder
    fun onBindViewHolder(holder: RecyclerView.ViewHolder?, item: ItemViewType)
}