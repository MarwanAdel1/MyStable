package com.example.mystable.modules.marketplace_post_details_fragment.data.repository

import com.example.mystable.modules.marketplace_post_details_fragment.data.data_source.MarketplacePostDetailsDataSource
import com.example.mystable.modules.marketplace_post_details_fragment.data.mapper.PostDetailsMapper
import com.example.mystable.modules.marketplace_post_details_fragment.domain.model.PostDetailsDomainModel
import com.example.mystable.modules.marketplace_post_details_fragment.domain.model.PostSimilarItemsDomain
import com.example.mystable.modules.marketplace_post_details_fragment.domain.repository.IMarketplacePostDetailsRepo
import javax.inject.Inject

class MarketplacePostDetailsRepo @Inject constructor(private val marketplaceCategoryDataSource: MarketplacePostDetailsDataSource) :
    IMarketplacePostDetailsRepo {

    override suspend fun getItemDetails(categoryId: Int, itemId: Int): PostDetailsDomainModel {
        return PostDetailsMapper.toPostDetailsDomainModel(
            marketplaceCategoryDataSource.getItemData(
                categoryId,
                itemId
            )
        )
    }

    override suspend fun getSimilarItems(categoryId: Int): PostSimilarItemsDomain {
        return PostDetailsMapper.toPostSimilarItemDomainModel(
            marketplaceCategoryDataSource.getSimilarItems(categoryId)
        )
    }
}