package com.example.mystable.di

import com.example.mystable.di.marketplace_activity.MarketplaceActivityScope
import com.example.mystable.di.marketplace_activity.MarketplaceFragmentBuildersModule
import com.example.mystable.presentation.marketplace_activity.MarketplaceActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {
    @MarketplaceActivityScope
    @ContributesAndroidInjector(
        modules = [
            MarketplaceModule::class,
            MarketplaceFragmentBuildersModule::class
        ]
    )
    abstract fun contributeMarketplaceActivity(): MarketplaceActivity
}