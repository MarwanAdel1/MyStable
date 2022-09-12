package com.example.mystable.modules.marketplace_posts_fragment.di

import androidx.lifecycle.ViewModel
import com.example.mystable.di.ViewModelKey
import com.example.mystable.modules.marketplace_posts_fragment.presentation.viewmodel.MarketPlaceViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MarketplaceViewModelsModule {
    @MarketplacePostsFragmentScope
    @Binds
    @IntoMap
    @ViewModelKey(MarketPlaceViewModel::class)
    abstract fun bindMarketplaceViewModelModule(marketPlaceViewModel: MarketPlaceViewModel): ViewModel
}