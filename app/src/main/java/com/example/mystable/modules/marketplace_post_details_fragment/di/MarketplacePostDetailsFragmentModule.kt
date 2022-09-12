package com.example.mystable.modules.marketplace_post_details_fragment.di

import com.example.mystable.modules.marketplace_post_details_fragment.data.data_source.MarketplacePostDetailsDataSource
import com.example.mystable.modules.marketplace_post_details_fragment.data.data_source.remote_source.RemoteMarketplacePostDetailsDataSource
import com.example.mystable.modules.marketplace_post_details_fragment.data.repository.MarketplacePostDetailsRepo
import com.example.mystable.modules.marketplace_post_details_fragment.domain.repository.IMarketplacePostDetailsRepo
import com.example.mystable.modules.marketplace_post_details_fragment.presentation.view.MarketplaceItemDetailsFragment
import com.example.mystable.modules.posts_adapter.presentation.view.PostsClickCallback
import dagger.Binds
import dagger.Module

@Module
abstract class MarketplacePostDetailsFragmentModule {
    @MarketplacePostDetailsFragmentScope
    @Binds
    abstract fun getMarketplacePostDetailsDataSource(remoteMarketplaceDataSource: RemoteMarketplacePostDetailsDataSource): MarketplacePostDetailsDataSource

    @MarketplacePostDetailsFragmentScope
    @Binds
    abstract fun getMarketplacePostDetailsRepo(remoteMarketplaceRepo: MarketplacePostDetailsRepo): IMarketplacePostDetailsRepo

    @MarketplacePostDetailsFragmentScope
    @Binds
    abstract fun getPostCallback(fragment: MarketplaceItemDetailsFragment): PostsClickCallback

    //Retrofit service
}