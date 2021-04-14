package com.example.apps10x.core.rvadapter.delegate

import com.example.apps10x.core.rvadapter.DelegateInterface
import com.example.apps10x.core.rvadapter.RecyclerViewListItem
import com.example.apps10x.core.rvadapter.viewHolders.BaseViewHolder

abstract class BaseDelegate : DelegateInterface {

    override fun onBindViewHolder(holder: BaseViewHolder, item: RecyclerViewListItem) {
        holder.bind(item)
    }

    override fun onViewDetachFromWindow(holder: BaseViewHolder, item: RecyclerViewListItem) {
        holder.detachToWindow(item)
    }

    override fun onViewAttachFromWindow(holder: BaseViewHolder, item: RecyclerViewListItem) {
        holder.attachToWindow(item)
    }
}