package com.example.myapplication.util.images

object ImageCacheFileNamingStrategy : CacheFileNamingStrategy {
    override fun isFromCache(cachedFileName: String): Boolean {
        return cachedFileName.startsWith(FILE_PREFIX, false) && cachedFileName.length == 32 + FILE_PREFIX.length
    }

    override fun map(from: String): String {
        return "$FILE_PREFIX${CryptoUtils.md5(from)}"
    }

    private const val FILE_PREFIX = "sli-"
}