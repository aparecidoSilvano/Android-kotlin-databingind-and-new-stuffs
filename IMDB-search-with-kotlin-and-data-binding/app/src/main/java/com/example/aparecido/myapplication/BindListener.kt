package com.example.aparecido.myapplication

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.squareup.picasso.Picasso

open class BindListener {

    companion object {
        @JvmStatic
        @BindingAdapter("picassoLoad")
        fun setImageUrl(imageView: ImageView, url: String?) {
            Picasso.get().load(url).into(imageView)
        }
    }
}