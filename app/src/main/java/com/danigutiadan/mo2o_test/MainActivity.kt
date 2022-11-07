package com.danigutiadan.mo2o_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.danigutiadan.mo2o_test.ui.BaseActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}