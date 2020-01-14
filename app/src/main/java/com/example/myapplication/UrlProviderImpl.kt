package com.example.myapplication

import android.content.Context
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UrlProviderImpl @Inject constructor(private val context: Context) : UrlProvider {
    override val baseUrl: String
        get() = context.getString(R.string.base_url)
}