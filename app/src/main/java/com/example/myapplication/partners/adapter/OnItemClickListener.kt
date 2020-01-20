package com.example.myapplication.partners.adapter

@FunctionalInterface
interface OnItemClickListener<T> {
    fun onItemClick(model: T)
}