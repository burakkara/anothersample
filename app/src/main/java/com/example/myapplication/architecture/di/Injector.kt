package com.example.myapplication.architecture.di

import com.example.myapplication.architecture.MainApplication

class Injector private constructor() {
    companion object {
        fun get(): AppComponent =
            MainApplication.get().appComponent
    }
}