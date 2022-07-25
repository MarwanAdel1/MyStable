package com.example.mystable.network

import com.example.mystable.model.DataSource
import com.example.mystable.pojo.Category
import com.example.mystable.pojo.CategoryDetails
import kotlinx.coroutines.delay

class MarketplaceDataSource {
    suspend fun getTabsInfo(flag: Boolean): List<Category> {
        delay(5000)
        if (flag) return DataSource.tabs else return emptyList()
    }

    suspend fun getTabDetails(id: String): CategoryDetails? {
        val details = getTabDetailsById(id)
        delay(5000)
        return details
    }

    // simulate backend server respond with a one tab details depends on tab clicked (tab id) not all tabs
    private fun getTabDetailsById(id: String): CategoryDetails? {
        var details: CategoryDetails? = null

        for (tabDetails in DataSource.tabsDetails) {
            if (tabDetails.id == id) {
                details = tabDetails
                break
            }
        }
        return details
    }
}