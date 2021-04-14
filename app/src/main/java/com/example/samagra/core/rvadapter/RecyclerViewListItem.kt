package com.example.apps10x.core.rvadapter

interface RecyclerViewListItem {
  fun getViewType(): Int
  fun getUnique(): Any
}