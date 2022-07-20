package com.example.mystable.screens.marketplace_fragment.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mystable.R
import com.example.mystable.databinding.TabDetailsItemBinding
import com.example.mystable.pojo.TabItems

class TabDetailsAdapter(
    private var tabItems: List<TabItems>
) : RecyclerView.Adapter<TabDetailsAdapter.ViewHolder>() {

    fun setTabDetails(tabItems: List<TabItems>) {
        this.tabItems = tabItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<TabDetailsItemBinding>(
            layoutInflater,
            R.layout.tab_details_item,
            parent,
            false
        )

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            itemName.text = tabItems[position].name
            itemPrice.text = "${tabItems[position].currencySymbol} ${tabItems[position].price}"
            itemImage.clipToOutline = true

            itemView.setOnClickListener {

            }
        }
    }

    override fun getItemCount(): Int {
        return tabItems.size
    }

    inner class ViewHolder(val binding: TabDetailsItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}