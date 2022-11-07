package com.danigutiadan.mo2o_test.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.danigutiadan.mo2o_test.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
    }
}