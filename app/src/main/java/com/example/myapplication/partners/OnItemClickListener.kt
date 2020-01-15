package com.example.myapplication.partners

@FunctionalInterface
interface OnItemClickListener<T> {
    fun onItemClick(model: T)
}