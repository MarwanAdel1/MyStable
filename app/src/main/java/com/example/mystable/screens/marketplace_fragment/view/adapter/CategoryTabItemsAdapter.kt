package com.example.mystable.screens.marketplace_fragment.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mystable.R
import com.example.mystable.databinding.ItemCategoryItemsBinding
import com.example.mystable.model.DataSource
import com.example.mystable.pojo.CategoryDetails
import com.example.mystable.screens.marketplace_fragment.view.MarketplaceCategoryItemsCallback

class CategoryTabItemsAdapter(
    private val myContext: Context,
    private var categoryDetailsItems: CategoryDetails,
    private val communicator: MarketplaceCategoryItemsCallback
) : RecyclerView.Adapter<CategoryTabItemsAdapter.MarketplaceCategoryDetailsViewHolder>() {

    fun setTabDetails(categoryDetailsItems: CategoryDetails) {
        this.categoryDetailsItems = categoryDetailsItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MarketplaceCategoryDetailsViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view = ItemCategoryItemsBinding.inflate(layoutInflater, parent, false)

        return MarketplaceCategoryDetailsViewHolder(view)
    }

    override fun onBindViewHolder(holder: MarketplaceCategoryDetailsViewHolder, position: Int) {
        holder.binding.apply {
            itemName.text = categoryDetailsItems.categoryItemData[position].name
            itemPrice.text =
                "${categoryDetailsItems.categoryItemData[position].currencySymbol} ${categoryDetailsItems.categoryItemData[position].price}"
            Glide.with(myContext)
                .load(DataSource.imageUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .centerCrop()
                .into(itemImage)

            itemImage.clipToOutline = true

            itemView.setOnClickListener {
                communicator.getCategoryItemDetails(
                    categoryDetailsItems.categoryId,
                    categoryDetailsItems.categoryItemData[position].id,
                    it
                )
            }
        }
    }

    override fun getItemCount(): Int {
        return categoryDetailsItems.categoryItemData.size
    }

    inner class MarketplaceCategoryDetailsViewHolder(val binding: ItemCategoryItemsBinding) :
        RecyclerView.ViewHolder(binding.root)
}