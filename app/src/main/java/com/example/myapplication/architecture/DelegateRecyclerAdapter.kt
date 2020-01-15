package com.example.myapplication.architecture

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

open class DelegateRecyclerViewAdapter<T : AdapterModel>(
    private val delegateManager: AdapterDelegateManager<T>
) : ListAdapter<T, RecyclerView.ViewHolder>(object : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return delegateManager.areItemsTheSame(oldItem, newItem)
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return delegateManager.areContentsTheSame(oldItem, newItem)
    }
}) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return delegateManager.onCreateViewHolder(parent, viewType)!!
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegateManager.onBindViewHolder(holder, getItem(position), position)
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int,
        payloads: List<Any>
    ) {
        delegateManager.onBindViewHolder(holder, getItem(position), position, payloads)
    }

    override fun getItemViewType(position: Int): Int {
        return delegateManager.getItemViewType(getItem(position), position)
    }

    fun getModelForViewHolder(viewHolder: RecyclerView.ViewHolder): T? {
        return delegateManager.getDelegateForViewType(viewHolder.itemViewType)
            ?.getModelForViewHolder(viewHolder)
    }

    override fun submitList(list: List<T>?) {
        delegateManager.onNewItems()
        super.submitList(list)
    }
}