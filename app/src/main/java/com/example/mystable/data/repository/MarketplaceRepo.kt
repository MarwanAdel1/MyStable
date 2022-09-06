package com.example.mystable.data.repository

import com.example.mystable.data.data_source.MarketplaceDataSource
import com.example.mystable.data.model.Category
import com.example.mystable.data.model.CategoryDetails
import com.example.mystable.data.model.ItemDetails
import com.example.mystable.data.model.ItemSimilarItem
import com.example.mystable.domain.repository.IMarketplaceRepo
import javax.inject.Inject

class MarketplaceRepo @Inject constructor(private val marketplaceDataSource: MarketplaceDataSource) :
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