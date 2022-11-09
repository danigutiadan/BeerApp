package com.danigutiadan.mo2o_test.binding

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

fun bindImageFromUrl(view: ImageView, imageUrl: String?, placeholder: Int? = null, circle: Boolean? = false) {
    if (!imageUrl.isNullOrEmpty()) {
        if (circle == false) {
            if (placeholder == null) {
                Glide.with(view.context)
                        .load(imageUrl)
                        .centerCrop()
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(view)
            } else {
                Glide.with(view.context)
                        .load(imageUrl)
                        .placeholder(placeholder)
                        .centerCrop()
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(view)
            }
        } else {
            if (placeholder == null) {
                Glide.with(view.context)
                        .load(imageUrl)
                        .centerCrop()
                        .circleCrop()
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(view)
            } else {
                Glide.with(view.context)
                        .load(imageUrl)
                        .placeholder(placeholder)
                        .centerCrop()
                        .circleCrop()
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(view)
            }
        }
    } else {
        if (circle == false) {
            if (placeholder == null) {
                Glide.with(view.context)
                        .load(imageUrl)
                        .centerCrop()
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(view)
            } else {
                Glide.with(view.context)
                        .load(imageUrl)
                        .centerCrop()
                        .placeholder(placeholder)
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(view)
            }
        } else {
            if (placeholder == null) {
                Glide.with(view.context)
                        .load(imageUrl)
                        .centerCrop()
                        .circleCrop()
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(view)
            } else {
                Glide.with(view.context)
                        .load(imageUrl)
                        .centerCrop()
                        .placeholder(placeholder)
                        .circleCrop()
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(view)
            }
        }
    }
}


