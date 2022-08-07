package com.example.mystable.screens.marketplace_item_details_fragment.view


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mystable.R
import com.example.mystable.databinding.*
import com.example.mystable.pojo.*
import java.text.SimpleDateFormat
import java.util.*


class ViewsRecyclerAdapter(
    private var itemTypes: MutableList<ICategoryItemsData>,
    private val myContext: Context,
    private val similarItemsCallback: MarketplaceItemDetailsSimilarItemCallback
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    fun setViews(itemTypes: List<ICategoryItemsData>) {
        this.itemTypes = itemTypes.toMutableList()
        notifyDataSetChanged()
    }

    fun setSimilarItems(items: ItemSimilarItem) {
        this.itemTypes.add(items)
        notifyItemChanged(this.itemTypes.size - 1)
    }

    override fun getItemViewType(position: Int): Int {
        when (position) {
            0 -> {
                if (itemTypes.any { it is ItemEssentialInfo }) {
                    return 0
                }
            }
            1 -> {
                if (itemTypes.any { it is ItemImages }) {
                    return 1
                }
            }
            2 -> {
                if (itemTypes.any { it is ItemDescription }) {
                    return 2
                }
            }
            3 -> {
                if (itemTypes.any { it is ItemOwner }) {
                    return 3
                }
            }
            4 -> {
                if (itemTypes.any { it is ItemLocation }) {
                    return 4
                }
            }
            5 -> {
                if (itemTypes.any { it is ItemInfo }) {
                    return 5
                } else if (itemTypes.any { it is ItemSimilarItem }) {
                    return 6
                }
            }
            6 -> {
                if (itemTypes.any { it is ItemSimilarItem }) {
                    return 6
                }
            }
        }
        return -1
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
            else -> throw IllegalArgumentException("Invalid View Type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ItemEssentialInfoViewHolder -> holder.bind(itemTypes.first { it is ItemEssentialInfo } as ItemEssentialInfo)
            is ItemImagesViewHolder -> holder.bind(itemTypes.first { it is ItemImages } as ItemImages)
            is ItemDescriptionViewHolder -> holder.bind(itemTypes.first { it is ItemDescription } as ItemDescription)
            is ItemOwnerViewHolder -> holder.bind(itemTypes.first { it is ItemOwner } as ItemOwner)
            is ItemMapViewHolder -> holder.bind(itemTypes.first { it is ItemLocation } as ItemLocation)
            is ItemInfoViewHolder -> holder.bind(itemTypes.first { it is ItemInfo } as ItemInfo)
            is SimilarItemsViewHolder -> holder.bind(itemTypes.first { it is ItemSimilarItem } as ItemSimilarItem)
        }
    }

    override fun getItemCount(): Int {
        return itemTypes.size
    }

    inner class ItemEssentialInfoViewHolder(private val binding: ItemCategoryItemEssentialInfoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(info: ItemEssentialInfo) {
            binding.itemName.text = info.name
            binding.itemPrice.text = "${info.currencySymbol} ${info.price}"
            binding.itemEndTime.text =
                "${myContext.getString(R.string.this_ad_ends)} ${convertDateToString(info.endDate)}"
        }

        private fun convertDateToString(date: Date): String {
            return SimpleDateFormat("d MMMM").format(date)
        }
    }

    inner class ItemImagesViewHolder(private val binding: ItemCategoryItemImagesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(images: ItemImages) {
            val imagesAdapter = ItemImagesRecyclerAdapter(myContext, images)
            binding.imagesRecyclerview.adapter = imagesAdapter
        }
    }

    inner class ItemDescriptionViewHolder(private val binding: ItemCategoryItemDescriptionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(desc: ItemDescription) {
            binding.descriptionTx.text = desc.description
        }
    }

    inner class ItemInfoViewHolder(private val binding: ItemCategoryItemInfoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(info: ItemInfo) {
            val infoRecyclerAdapter = InfoRecyclerAdapter(info)
            binding.itemInfoRecyclerView.adapter = infoRecyclerAdapter
            if (info.infoStatus) {
                binding.root.visibility = View.VISIBLE
            } else {
                binding.root.visibility = View.GONE
            }
        }
    }

    inner class ItemMapViewHolder(private val binding: ItemCategoryItemLocationDetailsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(location: ItemLocation) {
            binding.locationDescriptionTx.text = location.locationDescription
            // goz2 l map --- hb3t l parameter lel map fragment !!
        }
    }

    inner class ItemOwnerViewHolder(private val binding: ItemCategoryItemOwnerOrSoldBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(owner: ItemOwner) {
            if (owner.soldStatus) { // sold out
                changeVisibility(owner.soldStatus)
            } else {
                changeVisibility(owner.soldStatus)

                Glide.with(myContext)
                    .load(owner.owner.ownerImage)
                    .placeholder(R.drawable.ic_launcher_background)
                    .centerCrop()
                    .into(binding.ownerImage)

                binding.ownerName.text = owner.owner.ownerName
                binding.ownerDescTx.text = owner.owner.ownerDesc
                binding.ownerChatBt.setOnClickListener {

                }
                binding.ownerMailBt.setOnClickListener {

                }
                binding.ownerPhoneBt.setOnClickListener {

                }
            }
        }

        private fun changeVisibility(soldFlag: Boolean) {
            if (soldFlag) { // sold out
                binding.soldBt.visibility = View.VISIBLE

                binding.ownerAndSoldView.visibility = View.GONE
                binding.ownerImage.visibility = View.GONE
                binding.ownerName.visibility = View.GONE
                binding.ownerDescTx.visibility = View.GONE
                binding.ownerChatBt.visibility = View.GONE
                binding.ownerMailBt.visibility = View.GONE
                binding.ownerPhoneBt.visibility = View.GONE
            } else {
                binding.soldBt.visibility = View.GONE

                binding.ownerAndSoldView.visibility = View.VISIBLE
                binding.ownerImage.visibility = View.VISIBLE
                binding.ownerName.visibility = View.VISIBLE
                binding.ownerDescTx.visibility = View.VISIBLE
                binding.ownerChatBt.visibility = View.VISIBLE
                binding.ownerMailBt.visibility = View.VISIBLE
                binding.ownerPhoneBt.visibility = View.VISIBLE
            }
        }
    }

    inner class SimilarItemsViewHolder(private val binding: ItemCategoryItemSimilarItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(similarItem: ItemSimilarItem) {
            val similarItemAdapter = SimilarItemAdapter(
                myContext, ItemSimilarItem(
                    similarItem.categoryId,
                    similarItem.items
                ),
                similarItemsCallback
            )
            binding.similarItemsRecyclerview.adapter = similarItemAdapter
        }
    }
}
