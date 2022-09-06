package com.example.mystable.di.marketplace_activity

import com.example.mystable.di.marketplace_activity.marketplace_post_details.MarketplacePostDetailsFragmentModule
import com.example.mystable.di.marketplace_activity.marketplace_post_details.MarketplacePostDetailsFragmentScope
import com.example.mystable.di.marketplace_activity.marketplace_post_details.MarketplacePostDetailsViewModelsModule
import com.example.mystable.di.marketplace_activity.marketplace_posts.MarketplacePostsFragmentModule
import com.example.mystable.di.marketplace_activity.marketplace_posts.MarketplacePostsFragmentScope
import com.example.mystable.di.marketplace_activity.marketplace_posts.MarketplaceViewModelsModule
import com.example.mystable.marketplace_category_fragment.presentation.view.MarketplaceFragment
import com.example.mystable.marketplace_post_details_fragment.presentation.view.MarketplaceItemDetailsFragment
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