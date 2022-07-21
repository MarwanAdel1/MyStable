package com.example.mystable.screens.marketplace_fragment.view

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mystable.R
import com.example.mystable.databinding.ItemTabsBinding
import com.example.mystable.pojo.TabInfo

class TabsAdapter(
    private var tabs: List<TabInfo>,
    private var communicator: FragmentCommunicator
) : RecyclerView.Adapter<TabsAdapter.ViewHolder>() {
    var row_index = 0

    fun setTabsInfo(tabs: List<TabInfo>) {
        this.tabs = tabs
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ItemTabsBinding>(
            layoutInflater,
            R.layout.item_tabs,
            parent,
            false
        )

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            tabName.text = tabs[position].name

            if (position == row_index) {
                communicator.showDataForClickedItem(tabs[row_index])
                tabsView.setBackgroundResource(R.drawable.shape_rounded_corner_tabs_selected)
                tabName.setTextColor(Color.parseColor("#FFFFFF"))
            } else {
                tabsView.setBackgroundResource(R.drawable.shape_rounded_corner_tabs_unselcted)
                tabName.setTextColor(Color.parseColor("#000000"))
            }

            tabsView.setOnClickListener {
                row_index = position
                notifyDataSetChanged()
            }
        }
    }

    override fun getItemCount(): Int {
        return tabs.size
    }

    inner class ViewHolder(val binding: ItemTabsBinding) : RecyclerView.ViewHolder(binding.root)
}