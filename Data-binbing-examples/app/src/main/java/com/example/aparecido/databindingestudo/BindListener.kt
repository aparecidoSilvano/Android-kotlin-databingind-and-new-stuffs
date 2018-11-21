package com.example.aparecido.databindingestudo

import android.content.Context
import android.databinding.BindingAdapter
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.squareup.picasso.Picasso

open class BindListener : View.OnLongClickListener {
    override fun onLongClick(view: View?): Boolean {
        if (view != null) {
            Toast.makeText(view.context, "Click longo realizado", Toast.LENGTH_SHORT).show()
        }

        return true
    }

    fun onClickName(view: View, firstName: String, lastName: String) {
        Toast.makeText(view.context, "$firstName $lastName", Toast.LENGTH_SHORT).show()
    }

    fun onChangeState(context: Context, status: Boolean) {
        Toast.makeText(context, "Novo status: $status", Toast.LENGTH_SHORT).show()
    }

    companion object {
        @JvmStatic
        @BindingAdapter("picassoLoad")
        fun setImageUrl(imageView: ImageView, url: String?) {
            Picasso.get().load(url).into(imageView)
        }
    }
}