package com.example.mystable.marketplace_post_details_fragment.data.data_source

import com.example.mystable.marketplace_post_details_fragment.data.model.ItemDetails
import com.example.mystable.marketplace_post_details_fragment.data.model.ItemSimilarItem

interface MarketplacePostDetailsDataSource {
    suspend fun getItemData(categoryId: Int, itemId: Int): ItemDetails?

    suspend fun getSimilarItems(categoryId: Int): ItemSimilarItem?
}
