package com.example.mystable.screens.marketplace_fragment.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mystable.R
import com.example.mystable.databinding.ItemCategoryDetailsBinding
import com.example.mystable.model.DataSource
import com.example.mystable.pojo.CategoryDetailsItems

class TabDetailsAdapter(
    private val myContext: Context,
    private var categoryDetailsItems: List<CategoryDetailsItems>
) : RecyclerView.Adapter<TabDetailsAdapter.MarketplaceCategoryDetailsViewHolder>() {

    fun setTabDetails(categoryDetailsItems: List<CategoryDetailsItems>) {
        this.categoryDetailsItems = categoryDetailsItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MarketplaceCategoryDetailsViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view = ItemCategoryDetailsBinding.inflate(layoutInflater, parent, false)

        return MarketplaceCategoryDetailsViewHolder(view)
    }

    override fun onBindViewHolder(holder: MarketplaceCategoryDetailsViewHolder, position: Int) {
        holder.binding.apply {
            itemName.text = categoryDetailsItems[position].name
            itemPrice.text =
                "${categoryDetailsItems[position].currencySymbol} ${categoryDetailsItems[position].price}"
            Glide.with(myContext)
                .load(DataSource.imageUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .centerCrop()
                .into(itemImage)

            itemImage.clipToOutline = true

            itemView.setOnClickListener {

            }
        }
    }

    override fun getItemCount(): Int {
        return categoryDetailsItems.size
    }

    inner class MarketplaceCategoryDetailsViewHolder(val binding: ItemCategoryDetailsBinding) :
        RecyclerView.ViewHolder(binding.root)
}