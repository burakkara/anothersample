package com.example.myapplication.architecture.repository

import android.content.Context
import com.example.myapplication.R
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UrlProviderImpl @Inject constructor(private val context: Context) :
    UrlProvider {
    override val baseUrl: String
        get() = context.getString(R.string.base_url)
}