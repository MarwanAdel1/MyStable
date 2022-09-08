package com.example.mystable.modules.marketplace_category_fragment.data.repository

import com.example.mystable.modules.marketplace_category_fragment.data.data_source.MarketplaceCategoryDataSource
import com.example.mystable.modules.marketplace_category_fragment.data.model.Category
import com.example.mystable.modules.marketplace_category_fragment.data.model.CategoryDetails
import com.example.mystable.modules.marketplace_category_fragment.domain.repository.IMarketplaceCategoryRepo
import javax.inject.Inject

class MarketplaceCategoryRepo @Inject constructor(private val marketplaceCategoryDataSource: MarketplaceCategoryDataSource) :
    IMarketplaceCategoryRepo {

    override suspend fun getCategories(flag: Boolean): List<Category> {
        return marketplaceCategoryDataSource.getCatInfo(flag)
    }

    override suspend fun getCategoryDetails(id: Int): CategoryDetails? {
        return marketplaceCategoryDataSource.getCatItems(id)
    }
}