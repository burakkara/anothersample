package com.example.myapplication.architecture

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: Application) {
    @Provides
    @Singleton
    fun providesContext(): Context {
        return application
    }

    @Provides
    @Singleton
    fun providesApplication(): Application {
        return application
    }
}