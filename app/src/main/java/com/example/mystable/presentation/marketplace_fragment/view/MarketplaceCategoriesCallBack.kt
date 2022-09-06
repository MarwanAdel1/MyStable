package com.example.mystable.presentation.marketplace_fragment.view

import com.example.mystable.data.model.Category

interface MarketplaceCategoriesCallBack {
    fun setCategorySelected(rowIndex: Int)
    fun showDataForClickedItem(tab: Category)
}