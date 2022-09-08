package com.example.mystable.modules.marketplace_category_fragment.data.data_source.remote_source

import com.example.mystable.modules.marketplace_category_fragment.data.api.CategoryDataSource
import com.example.mystable.modules.marketplace_category_fragment.data.data_source.MarketplaceCategoryDataSource
import com.example.mystable.modules.marketplace_category_fragment.data.model.Category
import com.example.mystable.modules.marketplace_category_fragment.data.model.CategoryDetails
import kotlinx.coroutines.delay
import javax.inject.Inject

class RemoteMarketplaceCategoryDataSource @Inject constructor(private val marketApi: CategoryDataSource):
    MarketplaceCategoryDataSource {

    override suspend fun getCatInfo(flag: Boolean): List<Category> {
        delay(5000)
        return if (flag) marketApi.categories else emptyList()
    }

    override suspend fun getCatItems(id: Int): CategoryDetails? {
        val details = getCatItemsById(id)
        delay(5000)
        return details
    }

    // simulate backend server respond with a one tab details depends on tab clicked (tab id) not all tabs
    private fun getCatItemsById(id: Int): CategoryDetails? {
        var details: CategoryDetails? = null

        for (tabDetails in marketApi.categoryDetails) {
            if (tabDetails.categoryId == id) {
                details = tabDetails
                break
            }
        }
        return details
    }
}