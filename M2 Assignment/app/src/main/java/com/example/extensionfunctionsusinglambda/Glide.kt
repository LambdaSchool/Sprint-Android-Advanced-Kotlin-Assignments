package com.example.extensionfunctionsusinglambda

import android.graphics.drawable.Drawable


private fun loadurl(url:String){
    Glide.with(this)
        .load(url)
        .listener(object : RequestListener<Drawable> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                imageLoaded = false
                return false
            }
            ​
            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: Target<Drawable>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                imageLoaded = true
                return false
            }
        })
        .into(this)
}