package com.example.extensionfunctionsusinglambda

import android.content.Context
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide


fun ImageView.onSuccess(url: String, context: Context) {
    Glide.with(context).load(url).into(this)
}
fun ImageView.onFailure(url: String, context: Context) {
    Glide.with(context)
        .load(url)
        .into(this)
        Toast.makeText(context, "Please find an image", Toast.LENGTH_LONG).show()
}