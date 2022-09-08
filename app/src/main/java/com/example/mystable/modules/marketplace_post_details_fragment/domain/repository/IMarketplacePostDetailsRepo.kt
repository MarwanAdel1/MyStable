package com.example.mystable.modules.marketplace_post_details_fragment.domain.repository

import com.example.mystable.modules.marketplace_post_details_fragment.data.model.ItemDetails
import com.example.mystable.modules.marketplace_post_details_fragment.data.model.ItemSimilarItem

interface IMarketplacePostDetailsRepo {
    suspend fun getItemDetails(categoryId: Int, itemId: Int): ItemDetails?
    suspend fun getSimilarItems(categoryId: Int): ItemSimilarItem?
}