package com.example.mystable.modules.marketplace_post_details_fragment.presentation.view

import android.view.View
import com.example.mystable.modules.marketplace_category_fragment.data.model.CategoryItemData

interface MarketplaceItemDetailsSimilarItemCallback {
    fun getSimilarItemDetails(categoryId: Int, itemDetails: CategoryItemData, view: View)
}
