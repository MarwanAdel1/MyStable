package com.example.mystable.modules.marketplace_category_fragment.domain.usecases

import com.example.mystable.modules.marketplace_category_fragment.domain.repository.IMarketplaceCategoryRepo
import javax.inject.Inject

class GetCategories @Inject constructor(private val marketplaceRepo: IMarketplaceCategoryRepo) {
    suspend fun execute(returnedData: Boolean) = marketplaceRepo.getCategories(returnedData)
}
