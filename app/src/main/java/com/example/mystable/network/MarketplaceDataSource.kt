package com.example.mystable.network

import com.example.mystable.model.DataSource
import com.example.mystable.pojo.Category
import com.example.mystable.pojo.CategoryDetails
import com.example.mystable.pojo.ItemDetails
import com.example.mystable.pojo.ItemSimilarItem
import kotlinx.coroutines.delay

class MarketplaceDataSource {
    suspend fun getCatInfo(flag: Boolean): List<Category> {
        delay(5000)
        return if (flag) DataSource.categories else emptyList()
    }

    suspend fun getCatItems(id: Int): CategoryDetails? {
        val details = getCatItemsById(id)
        delay(5000)
        return details
    }

    suspend fun getItemData(categoryId: Int, itemId: Int): ItemDetails? {
        val itemDetails = getItemDataById(categoryId, itemId)
        delay(1500)
        return itemDetails
    }

    suspend fun getSimilarItems(categoryId: Int): ItemSimilarItem? {
        val details = getSimilarItemsById(categoryId)
        delay(6000)
        return details
    }

    // simulate backend server respond with a one tab details depends on tab clicked (tab id) not all tabs
    private fun getCatItemsById(id: Int): CategoryDetails? {
        var details: CategoryDetails? = null

        for (tabDetails in DataSource.CategoryDetails) {
            if (tabDetails.categoryId == id) {
                details = tabDetails
                break
            }
        }
        return details
    }

    private fun getItemDataById(categoryId: Int, itemId: Int): ItemDetails? {
        var itemData: ItemDetails? = null

        for (item in DataSource.categoryItemsDetails) {
            if (item.categoryId == categoryId && item.itemId == itemId) {
                itemData = item
                break
            }
        }

        return itemData
    }

    private fun getSimilarItemsById(categoryId: Int): ItemSimilarItem? {
        var details: ItemSimilarItem? = null

        for (items in DataSource.CategoryDetails) {
            if (items.categoryId == categoryId) {
                details = ItemSimilarItem(items.categoryId, items.categoryItemData)
                break
            }
        }
        return details
    }
}