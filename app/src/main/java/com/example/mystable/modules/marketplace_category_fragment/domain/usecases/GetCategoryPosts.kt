package com.example.mystable.modules.marketplace_category_fragment.domain.usecases

import com.example.mystable.modules.marketplace_category_fragment.domain.repository.IMarketplaceCategoryRepo
import javax.inject.Inject

class GetCategoryPosts @Inject constructor(private val marketplaceRepo: IMarketplaceCategoryRepo) {
    suspend fun execute(categoryId: Int) = marketplaceRepo.getCategoryDetails(categoryId)
}