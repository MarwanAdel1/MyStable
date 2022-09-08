package com.example.mystable.modules.marketplace_activity.di

import com.example.mystable.modules.marketplace_post_details_fragment.di.MarketplacePostDetailsFragmentModule
import com.example.mystable.modules.marketplace_post_details_fragment.di.MarketplacePostDetailsFragmentScope
import com.example.mystable.modules.marketplace_post_details_fragment.di.MarketplacePostDetailsViewModelsModule
import com.example.mystable.modules.marketplace_category_fragment.di.MarketplacePostsFragmentModule
import com.example.mystable.modules.marketplace_category_fragment.di.MarketplacePostsFragmentScope
import com.example.mystable.modules.marketplace_category_fragment.di.MarketplaceViewModelsModule
import com.example.mystable.modules.marketplace_category_fragment.presentation.view.MarketplaceFragment
import com.example.mystable.modules.marketplace_post_details_fragment.presentation.view.MarketplaceItemDetailsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MarketplaceFragmentBuildersModule {
    @MarketplacePostsFragmentScope
    @ContributesAndroidInjector(
        modules = [
            MarketplaceViewModelsModule::class,
            MarketplacePostsFragmentModule::class
        ]
    )
    abstract fun contributeMarketplaceFragment(): MarketplaceFragment

    @MarketplacePostDetailsFragmentScope
    @ContributesAndroidInjector(
        modules = [
            MarketplacePostDetailsViewModelsModule::class,
            MarketplacePostDetailsFragmentModule::class
        ]
    )
    abstract fun contributeMarketplacePostDetailsFragment(): MarketplaceItemDetailsFragment
}