package com.example.mystable.data.data_source.remote_source

import com.example.mystable.data.model.Category
import com.example.mystable.data.model.CategoryDetails
import com.example.mystable.data.model.ItemDetails
import com.example.mystable.data.model.ItemSimilarItem
import com.example.mystable.data.api.DataSource
import com.example.mystable.data.data_source.MarketplaceDataSource
import kotlinx.coroutines.delay
import javax.inject.Inject

class RemoteMarketplaceDataSource @Inject constructor(private val marketApi: DataSource):
    MarketplaceDataSource {
    override suspend fun getCatInfo(flag: Boolean): List<Category> {
        delay(5000)
        return if (flag) marketApi.categories else emptyList()
    }

    override suspend fun getCatItems(id: Int): CategoryDetails? {
        val details = getCatItemsById(id)
        delay(5000)
        return details
    }

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

    // simulate backend server respond with a one tab details depends on tab clicked (tab id) not all tabs
    private fun getCatItemsById(id: Int): CategoryDetails? {
        var details: CategoryDetails? = null

        for (tabDetails in marketApi.CategoryDetails) {
            if (tabDetails.categoryId == id) {
                details = tabDetails
                break
            }
        }
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

        for (items in marketApi.CategoryDetails) {
            if (items.categoryId == categoryId) {
                details = ItemSimilarItem(items.categoryId, items.categoryItemData)
                break
            }
        }
        return details
    }
}