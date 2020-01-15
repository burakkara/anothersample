package com.example.myapplication.util.images

import android.widget.ImageView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.io.File

object ImageLoader {
    fun loadImageWithCache(
        picasso: Picasso,
        cacheDir: File,
        cacheFileNamingStrategy: CacheFileNamingStrategy,
        from: String,
        into: ImageView
    ) {
        val cachedFileName = cacheFileNamingStrategy.map(from)
        val cachedFile = File(cacheDir, cachedFileName)

        if (cachedFile.exists()) {
            picasso.load(cachedFile).into(into, object : Callback {
                override fun onSuccess() {
                    // Do nothing
                }

                override fun onError(e: Exception?) {
                    picasso.load(from).into(into)
                }
            })
        } else {
            picasso.load(from).into(into)
        }
    }
}