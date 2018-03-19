package com.gfcomp.suslu.interfaces

/**
 * Created by Gozde Kaval on 3/16/2018.
 */
interface TabViewType {
    fun getTabName() : String
    fun getTabType() : TabType
    fun getViewType() : Int = TabFragmentType.LIST.id
}