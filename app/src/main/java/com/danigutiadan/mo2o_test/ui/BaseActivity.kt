package com.danigutiadan.mo2o_test.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.danigutiadan.mo2o_test.R
import com.danigutiadan.mo2o_test.util.Navigator
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
abstract class BaseActivity : AppCompatActivity() {

    @Inject
    lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
    }

    abstract fun showLoading()

    abstract fun hideLoading()

    fun logd(message: String? = "log_debug") =
        Timber.d(message)

    fun logw(message: String? = "log_warning") =
        Timber.w(message)

    fun loge(message: String? = "log_error") =
        Timber.e(message)
}