package com.example.mystable.modules.marketplace_posts_fragment.domain.repository

import com.example.mystable.modules.marketplace_posts_fragment.domain.model.CategoryDomainModel
import com.example.mystable.modules.marketplace_posts_fragment.domain.model.CategoryPostsDomainModel

interface IMarketplaceCategoryRepo {
    suspend fun getCategories(flag: Boolean): List<CategoryDomainModel>
    suspend fun getCategoryDetails(id: Int): CategoryPostsDomainModel?
}