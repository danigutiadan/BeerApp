package com.danigutiadan.mo2o_test.features.beer


import android.os.Bundle
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.danigutiadan.mo2o_test.R
import com.danigutiadan.mo2o_test.databinding.ActivityBeerBinding
import com.danigutiadan.mo2o_test.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BeerActivity : BaseActivity() {

    private lateinit var navController: NavController
    private lateinit var binding: ActivityBeerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBeerBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        navController = findNavController(R.id.nav_host_fragment)
        setSupportActionBar(binding.toolbar)
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun showLoading() {
        binding.progressBar.isVisible = true
    }

    override fun hideLoading() {
        binding.progressBar.isVisible = false
    }
}