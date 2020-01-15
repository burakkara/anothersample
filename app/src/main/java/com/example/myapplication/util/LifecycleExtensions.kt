package com.example.myapplication.util

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

inline fun <T> LifecycleOwner.onChange(liveData: LiveData<T>, crossinline changeListener: (T?) -> Unit) {
    liveData.observe(this, Observer { changeListener.invoke(it) })
}