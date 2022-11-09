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
                        .fitCenter()
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(view)
            } else {
                Glide.with(view.context)
                        .load(imageUrl)
                        .placeholder(placeholder)
                        .fitCenter()
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(view)
            }
        } else {
            if (placeholder == null) {
                Glide.with(view.context)
                        .load(imageUrl)
                        .fitCenter()
                        .circleCrop()
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(view)
            } else {
                Glide.with(view.context)
                        .load(imageUrl)
                        .placeholder(placeholder)
                        .fitCenter()
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
                        .fitCenter()
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(view)
            } else {
                Glide.with(view.context)
                        .load(imageUrl)
                        .fitCenter()
                        .placeholder(placeholder)
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(view)
            }
        } else {
            if (placeholder == null) {
                Glide.with(view.context)
                        .load(imageUrl)
                        .fitCenter()
                        .circleCrop()
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(view)
            } else {
                Glide.with(view.context)
                        .load(imageUrl)
                        .fitCenter()
                        .placeholder(placeholder)
                        .circleCrop()
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(view)
            }
        }
    }
}


