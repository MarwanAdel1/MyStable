package com.example.mystable.modules.marketplace_post_details_fragment.data.data_source.remote_source

import com.example.mystable.modules.marketplace_post_details_fragment.data.api.PostDetailsDataSourceService
import com.example.mystable.modules.marketplace_post_details_fragment.data.data_source.MarketplacePostDetailsDataSource
import com.example.mystable.modules.marketplace_post_details_fragment.data.model.ItemDetails
import com.example.mystable.modules.marketplace_post_details_fragment.data.model.ItemSimilarItem
import kotlinx.coroutines.delay
import javax.inject.Inject

class RemoteMarketplacePostDetailsDataSource @Inject constructor(private val marketApi: PostDetailsDataSourceService) :
    MarketplacePostDetailsDataSource {

    override suspend fun getItemData(categoryId: Int, itemId: Int): ItemDetails? {
        val itemDetails = getItemDataById(categoryId, itemId)
        delay(1500)
        return itemDetails
    }

    override suspend fun getSimilarItems(categoryId: Int): ItemSimilarItem? {
        val details = getSimilarItemsById(categoryId)
        delay(6000)
        return details
    }

    private fun getItemDataById(categoryId: Int, itemId: Int): ItemDetails? {
        var itemData: ItemDetails? = null

        for (item in marketApi.categoryItemsDetails) {
            if (item.categoryId == categoryId && item.itemId == itemId) {
                itemData = item
                break
            }
        }

        return itemData
    }

    private fun getSimilarItemsById(categoryId: Int): ItemSimilarItem? {
        var details: ItemSimilarItem? = null

        for (items in marketApi.categoryDetails) {
            if (items.categoryId == categoryId) {
                details = ItemSimilarItem(items.categoryId, items.categoryItemData)
                break
            }
        }
        return details
    }
}