package com.example.mystable.modules.marketplace_post_details_fragment.presentation.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mystable.databinding.ItemCategoryItemInfoFirstItemViewBinding
import com.example.mystable.databinding.ItemCategoryItemInfoItemsViewBinding
import com.example.mystable.modules.marketplace_post_details_fragment.data.model.ItemInfo
import java.text.SimpleDateFormat
import java.util.*

class InfoRecyclerAdapter(
    private var info: ItemInfo
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var infoData: List<Pair<String, Any>> = emptyList()

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        infoData = info.info!!.toList()
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        return if (viewType == 0) {
            val view =
                ItemCategoryItemInfoFirstItemViewBinding.inflate(layoutInflater, parent, false)
            ItemInfoFirstItemViewHolder(view)
        } else {
            val view = ItemCategoryItemInfoItemsViewBinding.inflate(layoutInflater, parent, false)
            ItemInfoViewHolder(view)
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ItemInfoFirstItemViewHolder -> {
                holder.apply {
                    binding.itemKeyTx.text = infoData[position].first
                    if (infoData[position].first.contentEquals("Date of birth")) {
                        binding.itemValueTx.text =
                            getDateString(infoData[position].second as Date)
                    } else {
                        binding.itemValueTx.text = infoData[position].second.toString()
                    }
                }
            }
            is ItemInfoViewHolder -> {
                holder.apply {
                    binding.itemKeyTx.text = infoData[position].first
                    if (infoData[position].first.contentEquals("Date of birth")) {
                        binding.itemValueTx.text =
                            getDateString(infoData[position].second as Date)
                    } else {
                        binding.itemValueTx.text = infoData[position].second.toString()
                    }
                }
            }
        }
    }

    private fun getDateString(date: Date): String {
        return SimpleDateFormat("d MMM, yyyy").format(date)
    }

    override fun getItemCount(): Int {
        return info.info?.toList()?.size ?: 0
    }


    inner class ItemInfoViewHolder(val binding: ItemCategoryItemInfoItemsViewBinding) :
        RecyclerView.ViewHolder(binding.root)

    inner class ItemInfoFirstItemViewHolder(val binding: ItemCategoryItemInfoFirstItemViewBinding) :
        RecyclerView.ViewHolder(binding.root)
}