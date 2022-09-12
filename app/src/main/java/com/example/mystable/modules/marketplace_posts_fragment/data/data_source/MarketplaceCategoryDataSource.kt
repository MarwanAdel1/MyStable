package com.example.mystable.modules.marketplace_posts_fragment.data.data_source

import com.example.mystable.modules.marketplace_posts_fragment.data.model.Category
import com.example.mystable.modules.marketplace_posts_fragment.data.model.CategoryDetails

interface MarketplaceCategoryDataSource {
    suspend fun getCatInfo(flag: Boolean): List<Category>
    suspend fun getCatItems(id: Int): CategoryDetails?
}
