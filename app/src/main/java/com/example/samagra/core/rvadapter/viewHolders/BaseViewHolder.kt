package com.example.apps10x.core.rvadapter.viewHolders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.apps10x.core.rvadapter.RecyclerViewListItem

abstract class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    abstract fun bind(item: RecyclerViewListItem)

    open fun attachToWindow(item: RecyclerViewListItem) {}

    open fun detachToWindow(item: RecyclerViewListItem) {}


}