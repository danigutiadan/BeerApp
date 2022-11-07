package com.danigutiadan.mo2o_test.util

import android.content.Context
import android.content.Intent
import androidx.fragment.app.FragmentActivity
import com.danigutiadan.mo2o_test.features.beer.BeerActivity

class Navigator(private val context: Context) {

    fun navigateToBeer(activity: FragmentActivity?, preserveStack: Boolean? = true) =
        navigateTo(activity, Intent(activity, BeerActivity::class.java), preserveStack)


    private fun navigateTo(activity: FragmentActivity?, intent: Intent, preserveStack: Boolean? = true) =
        if (preserveStack == true) {
            context.startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
        } else {
            activity?.finish()
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }
}