package com.example.myapplication.util.images

import com.example.myapplication.architecture.adapter.Mapper

interface CacheFileNamingStrategy :
    Mapper<String, String> {
    fun isFromCache(cachedFileName: String): Boolean
}