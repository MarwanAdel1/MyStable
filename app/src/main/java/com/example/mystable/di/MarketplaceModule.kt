package com.example.mystable.di

import com.example.mystable.data.data_source.MarketplaceDataSource
import com.example.mystable.data.data_source.remote_source.RemoteMarketplaceDataSource
import com.example.mystable.data.repository.MarketplaceRepo
import com.example.mystable.di.marketplace_activity.MarketplaceActivityScope
import com.example.mystable.domain.repository.IMarketplaceRepo
import dagger.Binds
import dagger.Module

@Module
abstract class MarketplaceModule {
    @MarketplaceActivityScope
    @Binds
    abstract fun getMarketplaceRepo(marketplaceRepo: MarketplaceRepo): IMarketplaceRepo

    @MarketplaceActivityScope
    @Binds
    abstract fun getMarketplaceDataSource(remoteMarketplaceDataSource: RemoteMarketplaceDataSource): MarketplaceDataSource
}