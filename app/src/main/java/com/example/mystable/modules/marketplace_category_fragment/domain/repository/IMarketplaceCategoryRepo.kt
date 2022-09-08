package com.example.mystable.modules.marketplace_category_fragment.domain.repository

import com.example.mystable.modules.marketplace_category_fragment.data.model.Category
import com.example.mystable.modules.marketplace_category_fragment.data.model.CategoryDetails

interface IMarketplaceCategoryRepo {
    suspend fun getCategories(flag: Boolean): List<Category>
    suspend fun getCategoryDetails(id: Int): CategoryDetails?
}