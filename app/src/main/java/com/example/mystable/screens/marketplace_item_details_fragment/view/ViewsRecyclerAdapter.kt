package com.example.mystable.screens.marketplace_item_details_fragment.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mystable.databinding.*
import com.example.mystable.pojo.*

class ViewsRecyclerAdapter(private val itemTypes: List<ICategoryItemsData>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        if (itemTypes.any { it is ItemEssentialInfo }) {
            return 0
        } else if (itemTypes.any { it is ItemImages }) {
            return 1
        } else if (itemTypes.any { it is ItemDescription }) {
            return 2
        } else if (itemTypes.any { it is ItemOwner }) {
            return 3
        } else if (itemTypes.any { it is ItemLocation }) {
            return 4
        } else if (itemTypes.any { it is ItemInfo }) {
            return 5
        } else if (itemTypes.any { it is ItemSimilarItem }) {
            return 6
        } else {
            return -1
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        when (viewType) {
            0 -> return ItemEssentialInfoViewHolder(
                ItemCategoryItemEssentialInfoBinding.inflate(
                    layoutInflater,
                    parent,
                    false
                )
            )
            1 -> return ItemImagesViewHolder(
                ItemCategoryItemImagesBinding.inflate(
                    layoutInflater,
                    parent,
                    false
                )
            )
            2 -> return ItemDescriptionViewHolder(
                ItemCategoryItemDescriptionBinding.inflate(
                    layoutInflater,
                    parent,
                    false
                )
            )
            3 -> return ItemOwnerViewHolder(
                ItemCategoryItemOwnerOrSoldBinding.inflate(
                    layoutInflater,
                    parent,
                    false
                )
            )
            4 -> return ItemMapViewHolder(
                ItemCategoryItemLocationDetailsBinding.inflate(
                    layoutInflater,
                    parent,
                    false
                )
            )
            5 -> return ItemInfoViewHolder(
                ItemCategoryItemInfoBinding.inflate(
                    layoutInflater,
                    parent,
                    false
                )
            )
            6 -> return SimilarItemsViewHolder(
                ItemCategoryItemSimilarItemsBinding.inflate(
                    layoutInflater,
                    parent,
                    false
                )
            )
            else -> return SimilarItemsViewHolder(
                ItemCategoryItemSimilarItemsBinding.inflate(
                    layoutInflater,
                    parent,
                    false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            0 -> {}
            1 -> {}
            2 -> {}
            3 -> {}
            4 -> {}
            5 -> {}
            6 -> {}
            else -> {}
        }
    }

    override fun getItemCount(): Int {
        return itemTypes.size
    }

    inner class ItemEssentialInfoViewHolder(binding: ItemCategoryItemEssentialInfoBinding) :
        RecyclerView.ViewHolder(binding.root)

    inner class ItemImagesViewHolder(binding: ItemCategoryItemImagesBinding) :
        RecyclerView.ViewHolder(binding.root)

    inner class ItemDescriptionViewHolder(binding: ItemCategoryItemDescriptionBinding) :
        RecyclerView.ViewHolder(binding.root)

    inner class ItemInfoViewHolder(binding: ItemCategoryItemInfoBinding) :
        RecyclerView.ViewHolder(binding.root)

    inner class ItemMapViewHolder(binding: ItemCategoryItemLocationDetailsBinding) :
        RecyclerView.ViewHolder(binding.root)

    inner class ItemOwnerViewHolder(binding: ItemCategoryItemOwnerOrSoldBinding) :
        RecyclerView.ViewHolder(binding.root)

    inner class SimilarItemsViewHolder(binding: ItemCategoryItemSimilarItemsBinding) :
        RecyclerView.ViewHolder(binding.root)
}