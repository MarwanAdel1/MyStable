package com.example.mystable.model

import com.example.mystable.network.MarketplaceDataSource
import com.example.mystable.pojo.Category
import com.example.mystable.pojo.CategoryDetails
import com.example.mystable.pojo.ItemDetails
import com.example.mystable.pojo.ItemSimilarItem

class MarketplaceRepo(private val marketplaceDataSource: MarketplaceDataSource) :
    IMarketplaceRepo {

    override suspend fun getCategories(flag: Boolean): List<Category> {
        return marketplaceDataSource.getCatInfo(flag)
    }

    override suspend fun getCategoryDetails(id: Int): CategoryDetails? {
        return marketplaceDataSource.getCatItems(id)
    }

    override suspend fun getItemDetails(categoryId: Int, itemId: Int): ItemDetails? {
        return marketplaceDataSource.getItemData(categoryId, itemId)
    }

    override suspend fun getSimilarItems(categoryId: Int): ItemSimilarItem? {
        return marketplaceDataSource.getSimilarItems(categoryId)
    }
}