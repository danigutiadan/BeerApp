package com.danigutiadan.mo2o_test
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.danigutiadan.mo2o_test.databinding.ActivityMainBinding
import com.danigutiadan.mo2o_test.ui.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //navController = findNavController(R.id.nav_host_fragment)
        subscribeUi(binding)
        //setSupportActionBar(binding.toolbar)
        //NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    private fun subscribeUi(binding: ActivityMainBinding) {
        Toast.makeText(this, "Esperando", Toast.LENGTH_LONG).show()
        Handler(Looper.getMainLooper()).postDelayed({
            navigateToSearch()
        }, 1000)



    }

    private fun navigateToSearch() {
        navigator.navigateToBeer(this, false)
    }
}