package com.example.mystable.modules.marketplace_category_fragment.presentation.view

import com.example.mystable.modules.marketplace_category_fragment.data.model.Category

interface MarketplaceCategoriesCallBack {
    fun setCategorySelected(rowIndex: Int)
    fun showDataForClickedItem(tab: Category)
}