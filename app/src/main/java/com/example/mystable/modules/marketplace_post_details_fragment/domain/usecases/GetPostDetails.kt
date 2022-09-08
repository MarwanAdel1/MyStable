package com.example.mystable.modules.marketplace_post_details_fragment.domain.usecases

import com.example.mystable.modules.marketplace_post_details_fragment.domain.repository.IMarketplacePostDetailsRepo
import javax.inject.Inject

class GetPostDetails @Inject constructor(private val marketplaceRepo: IMarketplacePostDetailsRepo) {
    suspend fun execute(categoryId: Int, postId: Int) =
        marketplaceRepo.getItemDetails(categoryId, postId)
}