package com.example.apps10x.core.rvadapter

import android.view.ViewGroup
import com.example.apps10x.core.rvadapter.viewHolders.BaseViewHolder

interface DelegateInterface {

    fun onCreateViewHolder(parent: ViewGroup): BaseViewHolder

    fun onBindViewHolder(holder: BaseViewHolder, item: RecyclerViewListItem)

    fun onViewDetachFromWindow(holder: BaseViewHolder, item: RecyclerViewListItem)

    fun onViewAttachFromWindow(holder: BaseViewHolder, item: RecyclerViewListItem)

}