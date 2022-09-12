package com.example.mystable.modules.post_category_adapter.presentation.view

import com.example.mystable.modules.post_category_adapter.presentation.model.CategoryAdapterModel

interface CategoriesCallBack {
    fun setCategorySelected(rowIndex: Int)
    fun showDataForClickedItem(tab: CategoryAdapterModel)
}