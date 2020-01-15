package com.example.myapplication.databinding

import android.graphics.Color
import android.graphics.Paint
import android.util.Log
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter

object StylingBindingAdapters {
    @BindingAdapter("show")
    @JvmStatic
    fun setVisibility(view: View, visible: Boolean) {
        view.visibility = if (visible) View.VISIBLE else View.GONE
    }

    @BindingAdapter("checkedOff")
    @JvmStatic
    fun setCheckedOff(textView: TextView, isChecked: Boolean) {
        val (paintFlags, alpha) = if (isChecked)
            (Paint.STRIKE_THRU_TEXT_FLAG or Paint.ANTI_ALIAS_FLAG) to 0.4f
        else
            Paint.ANTI_ALIAS_FLAG to 1f

        textView.paintFlags = paintFlags
        textView.alpha = alpha
    }

    @BindingAdapter("checkedOff")
    @JvmStatic
    fun setCheckedOff(imageView: ImageView, isChecked: Boolean) {
        imageView.alpha = if (isChecked) 0.4f else 1f
    }

    @JvmStatic
    @BindingAdapter("centered")
    fun bindCentered(textView: TextView, centered: Boolean) {
        textView.gravity = if (centered) Gravity.CENTER else Gravity.START
    }

    @JvmStatic
    @BindingAdapter("extraPadding")
    fun bindPadding(textView: TextView, extraPadding: Boolean) {
        textView.apply {
            val paddingDp = if (extraPadding) 16f else 4f
            val paddingPx = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, paddingDp, context.resources.displayMetrics)
            setPadding(paddingLeft, paddingPx.toInt(), paddingRight, paddingPx.toInt())
        }
    }

    @JvmStatic
    @BindingAdapter("strikethrough")
    fun bindStrikethroguh(textView: TextView, isStrikethrough: Boolean) {
        textView.paintFlags = if (isStrikethrough)
            (Paint.STRIKE_THRU_TEXT_FLAG or Paint.ANTI_ALIAS_FLAG)
        else
            Paint.ANTI_ALIAS_FLAG
    }

    @JvmStatic
    @BindingAdapter("background")
    fun setBackgroundColor(view: View, color: String?) {
        if(!color.isNullOrEmpty()) {
            try {
                view.setBackgroundColor(Color.parseColor(color))
            } catch(e: IllegalArgumentException) {
                Log.d("Binding adapter", e.message)
            }
        }
    }
}