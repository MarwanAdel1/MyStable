package com.example.mystable.domain.usecases

import com.example.mystable.domain.repository.IMarketplaceRepo
import javax.inject.Inject

class GetCategoryPosts @Inject constructor(private val marketplaceRepo: IMarketplaceRepo) {
    suspend fun execute(categoryId: Int) = marketplaceRepo.getCategoryDetails(categoryId)
}