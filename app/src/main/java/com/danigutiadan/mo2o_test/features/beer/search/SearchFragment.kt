package com.danigutiadan.mo2o_test.features.beer.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.danigutiadan.mo2o_test.R
import com.danigutiadan.mo2o_test.databinding.FragmentSearchBinding
import com.danigutiadan.mo2o_test.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : BaseFragment(R.layout.fragment_search) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentSearchBinding.bind(view)
        subscribeUi(binding)
    }

    private fun subscribeUi(binding: FragmentSearchBinding) {

    }

}