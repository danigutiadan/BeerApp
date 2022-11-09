package com.danigutiadan.mo2o_test

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import com.danigutiadan.mo2o_test.databinding.ActivityMainBinding
import com.danigutiadan.mo2o_test.ui.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        subscribeUi()
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    private fun subscribeUi() {
        Handler(Looper.getMainLooper()).postDelayed({
            navigateToSearch()
        }, 1000)
    }

    private fun navigateToSearch() {
        navigator.navigateToBeer(this, false)
    }
}