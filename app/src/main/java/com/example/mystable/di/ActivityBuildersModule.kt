package com.example.mystable.di

import com.example.mystable.modules.marketplace_activity.di.MarketplaceActivityScope
import com.example.mystable.modules.marketplace_activity.di.MarketplaceFragmentBuildersModule
import com.example.mystable.presentation.marketplace_activity.MarketplaceActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {
    @MarketplaceActivityScope
    @ContributesAndroidInjector(
        modules = [
            MarketplaceFragmentBuildersModule::class
        ]
    )
    abstract fun contributeMarketplaceActivity(): MarketplaceActivity
}