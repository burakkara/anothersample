package com.example.myapplication.util.images

import com.example.myapplication.Mapper

interface CacheFileNamingStrategy : Mapper<String, String> {
    fun isFromCache(cachedFileName: String): Boolean
}