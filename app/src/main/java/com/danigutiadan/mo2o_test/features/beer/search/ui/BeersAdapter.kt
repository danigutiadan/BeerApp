package com.danigutiadan.mo2o_test.features.beer.search.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.danigutiadan.mo2o_test.R
import com.danigutiadan.mo2o_test.binding.bindImageFromUrl
import com.danigutiadan.mo2o_test.features.beer.search.data.BeerResponse
import kotlinx.android.synthetic.main.item_beer.view.*

class BeersAdapter: RecyclerView.Adapter<BeersAdapter.BeersItemHolder>() {
    private var beers: List<BeerResponse> = emptyList()

    @SuppressLint("NotifyDataSetChanged")
    fun setBeers(beers: List<BeerResponse>) {
        this.beers = beers
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeersItemHolder = BeersItemHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_beer, parent, false))

    override fun onBindViewHolder(holder: BeersItemHolder, position: Int) = holder.bind(beers[position])

    override fun getItemCount(): Int {
        return beers.count()
    }

    class BeersItemHolder(itemView: View): RecyclerView.ViewHolder(itemView)  {
        fun bind(beer: BeerResponse) {
            itemView.apply {
                tv_item_beer_title.text = "Nombre: " + beer.name
                bindImageFromUrl(iv_item_beer, beer.imageUrl)
            }

        }
    }

}