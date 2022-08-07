package com.example.mystable.screens.marketplace_fragment.view

import android.view.View

interface MarketplaceCategoryItemsCallback {
    fun getCategoryItemDetails(categoryId: Int, itemId: Int, view: View)
}
