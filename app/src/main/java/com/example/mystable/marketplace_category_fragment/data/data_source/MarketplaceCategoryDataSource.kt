package com.example.mystable.marketplace_category_fragment.data.data_source

import com.example.mystable.marketplace_category_fragment.data.model.Category
import com.example.mystable.marketplace_category_fragment.data.model.CategoryDetails

interface MarketplaceCategoryDataSource {
    suspend fun getCatInfo(flag: Boolean): List<Category>
    suspend fun getCatItems(id: Int): CategoryDetails?
}
