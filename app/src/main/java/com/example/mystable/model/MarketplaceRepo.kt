package com.example.mystable.model

import com.example.mystable.network.MarketplaceDataSource
import com.example.mystable.pojo.Category
import com.example.mystable.pojo.CategoryDetails

class MarketplaceRepo(private val marketplaceDataSource: MarketplaceDataSource) :
    IMarketplaceRepo {

    override suspend fun getCategories(flag: Boolean): List<Category> {
        return marketplaceDataSource.getCatInfo(flag)
    }

    override suspend fun getCategoryDetails(id: Int): CategoryDetails? {
        return marketplaceDataSource.getCatItems(id)
    }
}