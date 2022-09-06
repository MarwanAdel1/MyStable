package com.example.mystable.presentation.marketplace_item_details_fragment.view

import android.view.View
import com.example.mystable.data.model.CategoryItemData

interface MarketplaceItemDetailsSimilarItemCallback {
    fun getSimilarItemDetails(categoryId: Int, itemDetails: CategoryItemData, view: View)
}
