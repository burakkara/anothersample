package com.example.myapplication.architecture

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

interface AdapterDelegate<T> {
    fun isForModel(adapterModel: T): Boolean

    fun getModelForViewHolder(viewHolder: RecyclerView.ViewHolder): T?

    fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder

    fun bindViewHolder(viewHolder: RecyclerView.ViewHolder, model: T, payloads: List<Any>)
}