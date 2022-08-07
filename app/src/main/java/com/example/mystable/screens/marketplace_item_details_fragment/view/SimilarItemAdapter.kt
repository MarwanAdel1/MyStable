package com.example.mystable.screens.marketplace_item_details_fragment.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mystable.R
import com.example.mystable.databinding.ItemCategoryItemsBinding
import com.example.mystable.model.DataSource
import com.example.mystable.pojo.ItemSimilarItem

class SimilarItemAdapter(
    private val myContext: Context,
    private var categoryItems: ItemSimilarItem,
    private val communicator: MarketplaceItemDetailsSimilarItemCallback
) : RecyclerView.Adapter<SimilarItemAdapter.SimilarItemsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimilarItemsViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view = ItemCategoryItemsBinding.inflate(
            layoutInflater,
            parent,
            false
        )

        return SimilarItemsViewHolder(view)
    }

    override fun onBindViewHolder(holder: SimilarItemsViewHolder, position: Int) {
        holder.binding.apply {
            itemName.text = categoryItems.items[position].name
            itemPrice.text =
                "${categoryItems.items[position].currencySymbol} ${categoryItems.items[position].price}"

            Glide.with(myContext)
                .load(DataSource.imageUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .centerCrop()
                .into(itemImage)

            itemImage.clipToOutline = true

            itemView.setOnClickListener {
                communicator.getSimilarItemDetails(
                    categoryItems.categoryId,
                    categoryItems.items[position],
                    it
                )
            }
        }
    }

    override fun getItemCount(): Int {
        return categoryItems.items.size
    }

    inner class SimilarItemsViewHolder(val binding: ItemCategoryItemsBinding) :
        RecyclerView.ViewHolder(binding.root)
}