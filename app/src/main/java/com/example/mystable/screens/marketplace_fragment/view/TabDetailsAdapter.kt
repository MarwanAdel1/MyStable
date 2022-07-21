package com.example.mystable.screens.marketplace_fragment.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mystable.R
import com.example.mystable.databinding.ItemTabDetailsBinding
import com.example.mystable.model.Data
import com.example.mystable.pojo.TabItems

class TabDetailsAdapter(
    private val myContext: Context,
    private var tabItems: List<TabItems>
) : RecyclerView.Adapter<TabDetailsAdapter.ViewHolder>() {

    fun setTabDetails(tabItems: List<TabItems>) {
        this.tabItems = tabItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ItemTabDetailsBinding>(
            layoutInflater,
            R.layout.item_tab_details,
            parent,
            false
        )

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            itemName.text = tabItems[position].name
            itemPrice.text = "${tabItems[position].currencySymbol} ${tabItems[position].price}"
            Glide.with(myContext)
                .load(Data.imageUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .centerCrop()
                .into(itemImage)

            itemImage.clipToOutline = true

            itemView.setOnClickListener {

            }
        }
    }

    override fun getItemCount(): Int {
        return tabItems.size
    }

    inner class ViewHolder(val binding: ItemTabDetailsBinding) :
        RecyclerView.ViewHolder(binding.root)
}