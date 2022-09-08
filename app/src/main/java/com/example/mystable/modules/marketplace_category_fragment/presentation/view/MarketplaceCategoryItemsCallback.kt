package com.example.mystable.modules.marketplace_category_fragment.presentation.view

import android.view.View

interface MarketplaceCategoryItemsCallback {
    fun getCategoryItemDetails(categoryId: Int, itemId: Int, view: View)
}
