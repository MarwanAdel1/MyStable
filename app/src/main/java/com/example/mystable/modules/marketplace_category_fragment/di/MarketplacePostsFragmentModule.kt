package com.example.mystable.modules.marketplace_category_fragment.di

import com.example.mystable.modules.marketplace_category_fragment.data.data_source.MarketplaceCategoryDataSource
import com.example.mystable.modules.marketplace_category_fragment.data.data_source.remote_source.RemoteMarketplaceCategoryDataSource
import com.example.mystable.modules.marketplace_category_fragment.data.repository.MarketplaceCategoryRepo
import com.example.mystable.modules.marketplace_category_fragment.domain.repository.IMarketplaceCategoryRepo
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


    //Retrofit service
}