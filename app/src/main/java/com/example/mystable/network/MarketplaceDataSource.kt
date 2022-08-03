package com.example.mystable.network

import com.example.mystable.model.DataSource
import com.example.mystable.pojo.Category
import com.example.mystable.pojo.CategoryDetails
import kotlinx.coroutines.delay

class MarketplaceDataSource {
    suspend fun getCatInfo(flag: Boolean): List<Category> {
        delay(5000)
        if (flag) return DataSource.categories else return emptyList()
    }

    suspend fun getCatItems(id: Int): CategoryDetails? {
        val details = getCatItemsById(id)
        delay(5000)
        return details
    }

    // simulate backend server respond with a one tab details depends on tab clicked (tab id) not all tabs
    private fun getCatItemsById(id: Int): CategoryDetails? {
        var details: CategoryDetails? = null

        for (tabDetails in DataSource.CategoryDetails) {
            if (tabDetails.id == id) {
                details = tabDetails
                break
            }
        }
        return details
    }
}