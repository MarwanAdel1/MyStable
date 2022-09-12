package com.example.mystable.modules.post_category_adapter.presentation.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.mystable.R
import com.example.mystable.databinding.ItemCategoryBinding
import com.example.mystable.modules.post_category_adapter.presentation.model.CategoryAdapterModel
import com.example.mystable.modules.post_category_adapter.presentation.view.CategoriesCallBack
import javax.inject.Inject

class CategoryAdapter @Inject constructor(
    private var myContext: Context,
    private var communicator: CategoriesCallBack
) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    private var rowIndex = -1

    private lateinit var tabs: List<CategoryAdapterModel>

    fun setCategoryTabsInfo(tabs: List<CategoryAdapterModel>) {
        this.tabs = tabs
        notifyDataSetChanged()
        if (this.tabs.isNotEmpty()) {
            communicator.showDataForClickedItem(this.tabs[0])
        }
    }

    fun setSelectedCategoryTab(rowIndex: Int) {
        if (this.rowIndex != rowIndex) {
            notifyItemChanged(this.rowIndex)
            this.rowIndex = rowIndex
            notifyItemChanged(this.rowIndex)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view = ItemCategoryBinding.inflate(layoutInflater, parent, false)

        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: CategoryViewHolder,
        @SuppressLint("RecyclerView") position: Int
    ) {
        holder.binding.apply {
            tabName.text = tabs[position].name

            if (rowIndex == position) {
                tabsView.setBackgroundResource(R.drawable.shape_rounded_corner_tabs_selected)
                tabName.setTextColor(ContextCompat.getColor(myContext, R.color.white))
            } else {
                tabsView.setBackgroundResource(R.drawable.shape_rounded_corner_image_btn_white_view)
                tabName.setTextColor(ContextCompat.getColor(myContext, R.color.black))
            }

            tabsView.setOnClickListener {
                if (rowIndex != position) {
                    communicator.setCategorySelected(position)
                    communicator.showDataForClickedItem(tabs[position])
                }
            }
        }
    }

    override fun getItemCount(): Int {
        var size = 0
        if (::tabs.isInitialized) {
            size = tabs.size
        }
        return size
    }

    inner class CategoryViewHolder(val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root)
}