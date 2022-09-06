package com.example.mystable.presentation.marketplace_fragment.view

import android.view.View

interface MarketplaceCategoryItemsCallback {
    fun getCategoryItemDetails(categoryId: Int, itemId: Int, view: View)
}
