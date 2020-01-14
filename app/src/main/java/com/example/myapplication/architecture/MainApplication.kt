package com.example.myapplication.architecture

import android.app.Application

class MainApplication : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        createAppComponent()
    }

    private fun createAppComponent() {
        appComponent =
            DaggerAppComponent.builder().applicationModule(ApplicationModule(this)).build()
    }

    companion object {
        private var INSTANCE: MainApplication? = null
        fun get(): MainApplication = INSTANCE!!
    }
}