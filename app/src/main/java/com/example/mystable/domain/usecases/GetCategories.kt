package com.example.mystable.domain.usecases

import com.example.mystable.domain.repository.IMarketplaceRepo
import javax.inject.Inject

class GetCategories @Inject constructor(private val marketplaceRepo: IMarketplaceRepo) {
    suspend fun execute(returnedData: Boolean) = marketplaceRepo.getCategories(returnedData)
}
