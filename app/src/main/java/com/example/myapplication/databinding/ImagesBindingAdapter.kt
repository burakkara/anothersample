package com.example.myapplication.databinding

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter
import com.example.myapplication.util.images.ImageCacheFileNamingStrategy
import com.example.myapplication.util.images.ImageLoader
import com.squareup.picasso.Picasso

object ImagesBindingAdapter {
    @BindingAdapter("imageUrl")
    @JvmStatic
    fun loadImageWithCache(imageView: ImageView, imageUrl: String?) {
        if (imageUrl.isNullOrEmpty()) {
            imageView.setImageDrawable(null)
            return
        }

        ImageLoader.loadImageWithCache(
            picasso = Picasso.get(),
            cacheDir = imageView.context.cacheDir,
            cacheFileNamingStrategy = ImageCacheFileNamingStrategy,
            from = imageUrl,
            into = imageView
        )
    }

    @BindingAdapter("icon")
    @JvmStatic
    fun setIcon(imageView: ImageView, @DrawableRes iconResourceId: Int) {
        when (iconResourceId) {
            0 -> {
                imageView.visibility = View.GONE
            }
            else -> {
                imageView.visibility = View.VISIBLE
                imageView.setImageResource(iconResourceId)
            }
        }
    }

    @BindingAdapter("src")
    @JvmStatic
    fun setImageDrawable(imageView: ImageView, drawable: Drawable?) {
        imageView.setImageDrawable(drawable)
    }
}

