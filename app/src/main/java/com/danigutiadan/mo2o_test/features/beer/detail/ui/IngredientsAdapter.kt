package com.danigutiadan.mo2o_test.features.beer.detail.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.danigutiadan.mo2o_test.R
import com.danigutiadan.mo2o_test.features.beer.search.data.Ingredient
import kotlinx.android.synthetic.main.item_ingredient.view.*

class IngredientsAdapter: RecyclerView.Adapter<IngredientsAdapter.IngredientsItemHolder>() {

    private var ingredients: List<Ingredient> = mutableListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun setIngredients(ingredients: List<Ingredient>) {
        this.ingredients = ingredients
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): IngredientsItemHolder = IngredientsItemHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_ingredient, parent, false)
    )

    override fun onBindViewHolder(holder: IngredientsItemHolder, position: Int) = holder.bind(ingredients[position])

    override fun getItemCount(): Int = ingredients.count()

    class IngredientsItemHolder(itemView: View): RecyclerView.ViewHolder(itemView)  {

        fun bind(ingredient: Ingredient) {
            itemView.apply {
                tv_item_ingredient.text = context.getString(R.string.ingredient, ingredient.name, ingredient.amount?.value.toString(), ingredient.amount?.unit)
            }

        }
    }
}