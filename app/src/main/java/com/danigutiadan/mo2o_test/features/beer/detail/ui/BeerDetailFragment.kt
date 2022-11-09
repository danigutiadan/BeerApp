package com.danigutiadan.mo2o_test.features.beer.detail.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.danigutiadan.mo2o_test.R
import com.danigutiadan.mo2o_test.binding.bindImageFromUrl
import com.danigutiadan.mo2o_test.databinding.FragmentBeerDetailBinding
import com.danigutiadan.mo2o_test.features.beer.search.data.BeerResponse
import com.danigutiadan.mo2o_test.ui.BaseFragment
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BeerDetailFragment : BaseFragment(R.layout.fragment_beer_detail) {
    private var beer: BeerResponse? = null
    private val args: BeerDetailFragmentArgs by navArgs()
    private val maltAdapter = IngredientsAdapter()
    private val hopsAdapter = IngredientsAdapter()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentBeerDetailBinding.bind(view)
        subscribeUi(binding)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        beer = Gson().fromJson(args.beer, BeerResponse::class.java)
    }

    private fun subscribeUi(binding: FragmentBeerDetailBinding) {
        binding.apply {
            toolbar.apply {
                ivToolbarBack.apply {
                    isVisible = true
                    setOnClickListener {
                        activity?.onBackPressed()
                    }
                }
            }
            rvBeerDetailMalt.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = maltAdapter

            }

            rvBeerDetailHops.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = hopsAdapter

            }
            beer?.ingredients?.malt?.let { maltAdapter.setIngredients(it) }
            beer?.ingredients?.hops?.let { hopsAdapter.setIngredients(it) }

            tvTitleBeerDetail.text = beer?.name
            tvTaglineBeerDetail.text = beer?.tagline
            bindImageFromUrl(ivBeerDetail, beer?.imageUrl)
            tvBeerDetailDescription.text = beer?.description
            tvBeerDetailVolume.text = context?.getString(R.string.volume, beer?.volume?.value.toString(), beer?.volume?.unit)
            tvBeerDetailBoilVolume.text = context?.getString(R.string.boil_volume, beer?.boilVolume?.value.toString(), beer?.boilVolume?.unit)
            tvBeerDetailYeast.text = beer?.ingredients?.yeast
        }

    }
}