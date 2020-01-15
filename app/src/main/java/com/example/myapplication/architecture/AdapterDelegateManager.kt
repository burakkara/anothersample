package com.example.myapplication.architecture

import android.view.ViewGroup
import androidx.collection.SparseArrayCompat
import androidx.recyclerview.widget.RecyclerView


open class AdapterDelegateManager<T : AdapterModel>(
    vararg delegateArray: AdapterDelegate<T>
) {
    private val delegates = delegateArray.toList()
    private val typeToDelegatesMap = SparseArrayCompat<AdapterDelegate<T>>().apply {
        delegates.forEachIndexed { index, it -> put(index, it) }
    }
    private val listPositionToDelegateMap = SparseArrayCompat<AdapterDelegate<T>>()
    private var invalidateDelegateMap = false

    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder? {
        return getDelegateForViewType(viewType)?.createViewHolder(parent)
    }

    fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: T, position: Int) {
        onBindViewHolder(holder, item, position, EMPTY_PAYLOADS)
    }

    fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: T, position: Int, payloads: List<Any>) {
        getDelegateForItem(item, position)?.bindViewHolder(holder, item, payloads)
    }

    fun getItemViewType(item: T, position: Int): Int {
        return delegates.indexOf(getDelegateForItem(item, position))
    }

    fun onNewItems() {
        invalidateDelegateMap = true
    }

    fun getDelegateForViewType(viewType: Int): AdapterDelegate<T>? {
        return typeToDelegatesMap[viewType]
    }

    fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.id == newItem.id
    }

    fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }

    private fun getDelegateForItem(item: T, position: Int): AdapterDelegate<T>? {
        if (invalidateDelegateMap) {
            listPositionToDelegateMap.clear()
        } else if (listPositionToDelegateMap[position] != null) {
            return listPositionToDelegateMap[position]
        }
        val delegate = delegates.find { it.isForModel(item) }
            ?: throw DelegateNotFoundException("Could not find delegate for item at position $position: $item")
        listPositionToDelegateMap.put(position, delegate)
        return delegate
    }

    companion object {
        private val EMPTY_PAYLOADS = emptyList<Any>()
    }
}