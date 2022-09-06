package com.example.mystable.di.marketplace_activity.marketplace_post_details

import com.example.mystable.marketplace_post_details_fragment.data.data_source.MarketplacePostDetailsDataSource
import com.example.mystable.marketplace_post_details_fragment.data.data_source.remote_source.RemoteMarketplacePostDetailsDataSource
import com.example.mystable.marketplace_post_details_fragment.data.repository.MarketplacePostDetailsRepo
import com.example.mystable.marketplace_post_details_fragment.domain.repository.IMarketplacePostDetailsRepo
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
}