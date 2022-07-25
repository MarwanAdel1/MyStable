package com.example.mystable.screens.marketplace_fragment.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mystable.R
import com.example.mystable.databinding.ItemCategoryBinding
import com.example.mystable.pojo.Category

class TabsAdapter(
    private var myContext: Context,
    private var tabs: List<Category>,
    private var communicator: MarketplaceCategoriesCallBack
) : RecyclerView.Adapter<TabsAdapter.MarketplaceCategoryViewHolder>() {
    var rowIndex = 0

    fun setTabsInfo(tabs: List<Category>) {
        this.tabs = tabs
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MarketplaceCategoryViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ItemCategoryBinding>(
            layoutInflater,
            R.layout.item_category,
            parent,
            false
        )

        return MarketplaceCategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: MarketplaceCategoryViewHolder, position: Int) {
        holder.binding.apply {
            tabName.text = tabs[position].name

            if (position == rowIndex) {
                communicator.showDataForClickedItem(tabs[rowIndex])
                tabsView.setBackgroundResource(R.drawable.shape_rounded_corner_tabs_selected)
                tabName.setTextColor(ContextCompat.getColor(myContext, R.color.white))
            } else {
                tabsView.setBackgroundResource(R.drawable.ripple_rounded_corner_view_unselected)
                tabName.setTextColor(ContextCompat.getColor(myContext, R.color.black))
            }

            tabsView.setOnClickListener {
                if (rowIndex != position) {
                    rowIndex = position
                    notifyDataSetChanged()
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return tabs.size
    }

    inner class MarketplaceCategoryViewHolder(val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root)
}