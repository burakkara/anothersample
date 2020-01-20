package com.example.myapplication.architecture

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

open class BaseViewModel : ViewModel() {
    protected val disposables = CompositeDisposable()

    override fun onCleared() {
        disposables.clear()
    }
}