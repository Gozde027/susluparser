package com.gfcomp.suslu.interfaces

import android.support.v4.app.Fragment

/**
 * Created by Gozde Kaval on 3/16/2018.
 */
interface TabDelegateAdapter {
    fun getItem(tabType : TabType): Fragment
}