package com.danigutiadan.mo2o_test.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.danigutiadan.mo2o_test.R
import com.danigutiadan.mo2o_test.util.Navigator
import javax.inject.Inject

abstract class BaseFragment(fragment: Int) : Fragment(fragment) {

    @Inject
    lateinit var navigator: Navigator

    fun logd(message: String?) =
        (activity as BaseActivity?)?.logd(message)

    fun logw(message: String?) =
        (activity as BaseActivity?)?.logw(message)

    fun loge(message: String?) =
        (activity as BaseActivity?)?.loge(message)

    protected fun finish() =
        (activity as BaseActivity?)?.finish()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
