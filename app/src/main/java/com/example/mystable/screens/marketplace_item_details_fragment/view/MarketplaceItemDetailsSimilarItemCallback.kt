package com.example.mystable.screens.marketplace_item_details_fragment.view

import android.view.View
import com.example.mystable.pojo.CategoryItemData

interface MarketplaceItemDetailsSimilarItemCallback {
    fun getSimilarItemDetails(categoryId: Int, itemDetails: CategoryItemData, view: View)
}
