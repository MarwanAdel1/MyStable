package com.example.mystable.marketplace_post_details_fragment.data.repository

import com.example.mystable.marketplace_post_details_fragment.domain.repository.IMarketplacePostDetailsRepo
import com.example.mystable.marketplace_post_details_fragment.data.data_source.MarketplacePostDetailsDataSource
import com.example.mystable.marketplace_post_details_fragment.data.model.ItemDetails
import com.example.mystable.marketplace_post_details_fragment.data.model.ItemSimilarItem
import javax.inject.Inject

class MarketplacePostDetailsRepo @Inject constructor(private val marketplaceCategoryDataSource: MarketplacePostDetailsDataSource) :
    IMarketplacePostDetailsRepo {

    override suspend fun getItemDetails(categoryId: Int, itemId: Int): ItemDetails? {
        return marketplaceCategoryDataSource.getItemData(categoryId, itemId)
    }

    override suspend fun getSimilarItems(categoryId: Int): ItemSimilarItem? {
        return marketplaceCategoryDataSource.getSimilarItems(categoryId)
    }
}