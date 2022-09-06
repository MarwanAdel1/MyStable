package com.example.mystable.di.marketplace_activity

import com.example.mystable.di.marketplace_activity.marketplace_post_details.MarketplacePostDetailsFragmentScope
import com.example.mystable.di.marketplace_activity.marketplace_post_details.MarketplacePostDetailsViewModelsModule
import com.example.mystable.di.marketplace_activity.marketplace_posts.MarketplacePostsFragmentScope
import com.example.mystable.di.marketplace_activity.marketplace_posts.MarketplaceViewModelsModule
import com.example.mystable.presentation.marketplace_fragment.view.MarketplaceFragment
import com.example.mystable.presentation.marketplace_item_details_fragment.view.MarketplaceItemDetailsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MarketplaceFragmentBuildersModule {
    @MarketplacePostsFragmentScope
    @ContributesAndroidInjector(
        modules = [
            MarketplaceViewModelsModule::class
        ]
    )
    abstract fun contributeMarketplaceFragment(): MarketplaceFragment

    @MarketplacePostDetailsFragmentScope
    @ContributesAndroidInjector(
        modules = [
            MarketplacePostDetailsViewModelsModule::class
        ]
    )
    abstract fun contributeMarketplacePostDetailsFragment(): MarketplaceItemDetailsFragment
}