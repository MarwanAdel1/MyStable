package com.example.mystable.modules.marketplace_post_details_fragment.domain.repository

import com.example.mystable.modules.marketplace_post_details_fragment.domain.model.PostDetailsDomainModel
import com.example.mystable.modules.marketplace_post_details_fragment.domain.model.PostSimilarItemsDomain

interface IMarketplacePostDetailsRepo {
    suspend fun getItemDetails(categoryId: Int, itemId: Int): PostDetailsDomainModel?
    suspend fun getSimilarItems(categoryId: Int): PostSimilarItemsDomain?
}