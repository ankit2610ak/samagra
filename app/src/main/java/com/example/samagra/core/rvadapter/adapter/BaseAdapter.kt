package com.example.apps10x.core.rvadapter.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.apps10x.core.rvadapter.BaseDiffUtils
import com.example.apps10x.core.rvadapter.DelegateInterface
import com.example.apps10x.core.rvadapter.RecyclerViewListItem
import com.example.apps10x.core.rvadapter.exceptions.NoDelegateFoundException
import com.example.apps10x.core.rvadapter.viewHolders.BaseViewHolder


/**
 * Base adapter for any recycler view, all recycler view adapter must extend this to make the adapter
 * follow the delegate pattern
 * Refer to the url if you don't know much about the adapter delegate pattern
 * http://hannesdorfmann.com/android/adapter-delegates
 */

abstract class BaseAdapter : RecyclerView.Adapter<BaseViewHolder>() {

  // all the elements for this adapter
  private var items: MutableList<RecyclerViewListItem> = mutableListOf()

  private var viewGroup: ViewGroup? = null
  // the delegates needed for this adapter
  protected var delegates = HashMap<Int, DelegateInterface>()

  override fun getItemCount(): Int {
    // Log.d("infinite item size", "" + items.size)
    return items.size
  }

  fun getItemAtPosition(position: Int): RecyclerViewListItem {
    return items[position]
  }

  protected fun getItemAt(postion: Int): RecyclerViewListItem {
    return items[postion]
  }

  fun updateData(items: MutableList<RecyclerViewListItem>) {
    val diffResult = DiffUtil.calculateDiff(BaseDiffUtils(this.items, items))
    this.items.clear()
    this.items.addAll(items)
    diffResult.dispatchUpdatesTo(this)
  }

  abstract fun initDelegates()

  override fun getItemViewType(position: Int) = items[position].getViewType()

  override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
    delegates[getItemViewType(position)]?.onBindViewHolder(holder, items[position])
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
    viewGroup = parent
    return try {
      delegates[viewType]?.onCreateViewHolder(parent)!!
    } catch (e: KotlinNullPointerException) {
      throw NoDelegateFoundException(viewType, this::class.java.simpleName)
    }
  }

  override fun onViewAttachedToWindow(holder: BaseViewHolder) {
    super.onViewAttachedToWindow(holder)
    if (holder.adapterPosition != -1)
      delegates[getItemViewType(holder.adapterPosition)]?.onViewAttachFromWindow(holder, items[holder.adapterPosition])
  }

  override fun onViewDetachedFromWindow(holder: BaseViewHolder) {
    super.onViewDetachedFromWindow(holder)
    if (holder.adapterPosition != -1)
      delegates[getItemViewType(holder.adapterPosition)]?.onViewDetachFromWindow(holder, items[holder.adapterPosition])

  }
}