package com.kismiwati.homospecies

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

//pada bagian ini merupakan bagian untuk persiapan binding adapter
@BindingAdapter("image_url")
fun imageUrl(imageView: ImageView, url : String){
    Glide.with(imageView)
        .load(url)
        .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
        .into(imageView)
}