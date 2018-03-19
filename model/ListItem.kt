package com.gfcomp.suslu.model

import android.os.Parcel
import android.os.Parcelable
import com.gfcomp.suslu.interfaces.ItemViewType
import com.gfcomp.suslu.interfaces.TabViewType

/**
 * Created by Gozde Kaval on 3/12/2018.
 */
data class ListItem(val title: String? = null) : ItemViewType, Parcelable {

    override fun getViewType(): Int {
        return 1
    }

    constructor(source: Parcel) : this(
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(title)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<ListItem> = object : Parcelable.Creator<ListItem> {
            override fun createFromParcel(source: Parcel): ListItem = ListItem(source)
            override fun newArray(size: Int): Array<ListItem?> = arrayOfNulls(size)
        }
    }
}