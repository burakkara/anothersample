package com.example.myapplication.architecture

import android.app.Application
import com.example.myapplication.architecture.di.AppComponent
import com.example.myapplication.architecture.di.ApplicationModule
import com.example.myapplication.architecture.di.DaggerAppComponent

class MainApplication : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        createAppComponent()
    }

    private fun createAppComponent() {
        appComponent =
            DaggerAppComponent.builder().applicationModule(
                ApplicationModule(
                    this
                )
            ).build()
    }

    companion object {
        private var INSTANCE: MainApplication? = null
        fun get(): MainApplication = INSTANCE!!
    }
}