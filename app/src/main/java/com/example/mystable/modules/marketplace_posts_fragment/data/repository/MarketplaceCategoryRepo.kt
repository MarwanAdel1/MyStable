package com.example.mystable.modules.marketplace_posts_fragment.data.repository

import com.example.mystable.modules.marketplace_posts_fragment.data.data_source.MarketplaceCategoryDataSource
import com.example.mystable.modules.marketplace_posts_fragment.data.mapper.CategoryDataMapper
import com.example.mystable.modules.marketplace_posts_fragment.data.mapper.PostsDataMapper
import com.example.mystable.modules.marketplace_posts_fragment.domain.model.CategoryDomainModel
import com.example.mystable.modules.marketplace_posts_fragment.domain.model.CategoryPostsDomainModel
import com.example.mystable.modules.marketplace_posts_fragment.domain.repository.IMarketplaceCategoryRepo
import javax.inject.Inject

class MarketplaceCategoryRepo @Inject constructor(private val marketplaceCategoryDataSource: MarketplaceCategoryDataSource) :
    IMarketplaceCategoryRepo {

    override suspend fun getCategories(flag: Boolean): List<CategoryDomainModel> {
        return CategoryDataMapper.categoryToDomainModel(
            marketplaceCategoryDataSource.getCatInfo(
                flag
            )
        )
    }

    override suspend fun getCategoryDetails(id: Int): CategoryPostsDomainModel? {
        return marketplaceCategoryDataSource.getCatItems(id)
            ?.let { PostsDataMapper.postsToPostsDomainModel(it) }
    }
}