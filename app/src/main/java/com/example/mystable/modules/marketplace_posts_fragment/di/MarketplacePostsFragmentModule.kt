package com.example.mystable.modules.marketplace_posts_fragment.di

import com.example.mystable.modules.marketplace_posts_fragment.data.data_source.MarketplaceCategoryDataSource
import com.example.mystable.modules.marketplace_posts_fragment.data.data_source.remote_source.RemoteMarketplaceCategoryDataSource
import com.example.mystable.modules.marketplace_posts_fragment.data.repository.MarketplaceCategoryRepo
import com.example.mystable.modules.marketplace_posts_fragment.domain.repository.IMarketplaceCategoryRepo
import com.example.mystable.modules.marketplace_posts_fragment.presentation.view.MarketplacePostsFragment
import com.example.mystable.modules.post_category_adapter.presentation.view.CategoriesCallBack
import com.example.mystable.modules.posts_adapter.presentation.view.PostsClickCallback
import dagger.Binds
import dagger.Module

@Module
abstract class MarketplacePostsFragmentModule {
    @MarketplacePostsFragmentScope
    @Binds
    abstract fun getMarketplaceCategoryDataSource(remoteMarketplaceDataSource: RemoteMarketplaceCategoryDataSource): MarketplaceCategoryDataSource


    @MarketplacePostsFragmentScope
    @Binds
    abstract fun getMarketplaceCategoryRepo(remoteMarketplaceRepo: MarketplaceCategoryRepo): IMarketplaceCategoryRepo

    @MarketplacePostsFragmentScope
    @Binds
    abstract fun getPostCallback(fragment: MarketplacePostsFragment): PostsClickCallback

    @MarketplacePostsFragmentScope
    @Binds
    abstract fun getCategoryCallback(
        fragment: MarketplacePostsFragment
    ): CategoriesCallBack

    //Retrofit service
}