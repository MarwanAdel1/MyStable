package com.example.mystable.modules.marketplace_post_details_fragment.di

import androidx.lifecycle.ViewModel
import com.example.mystable.di.ViewModelKey
import com.example.mystable.modules.marketplace_post_details_fragment.presentation.viewmodel.MarketplaceItemDetailsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MarketplacePostDetailsViewModelsModule {
    @MarketplacePostDetailsFragmentScope
    @Binds
    @IntoMap
    @ViewModelKey(MarketplaceItemDetailsViewModel::class)
    abstract fun bindMarketplacePostDetailsViewModelModule(marketplaceItemDetailsViewModel: MarketplaceItemDetailsViewModel): ViewModel
}
