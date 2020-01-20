package com.example.myapplication.util

import com.google.gson.Gson
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GsonProviderImpl @Inject constructor() : GsonProvider {
    override val gson: Gson by lazy {
        Gson()
    }
}