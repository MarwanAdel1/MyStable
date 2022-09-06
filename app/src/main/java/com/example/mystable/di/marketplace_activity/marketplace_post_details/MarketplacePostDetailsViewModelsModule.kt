package com.example.mystable.di.marketplace_activity.marketplace_post_details

import androidx.lifecycle.ViewModel
import com.example.mystable.di.ViewModelKey
import com.example.mystable.presentation.marketplace_item_details_fragment.viewmodel.MarketplaceItemDetailsViewModel
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
