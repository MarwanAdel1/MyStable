package com.example.mystable.screens.marketplace_item_details_fragment.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mystable.model.IMarketplaceRepo

class MarketplaceItemDetailsViewModelFactory(private val marketplaceRepo: IMarketplaceRepo) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MarketplaceItemDetailsViewModel::class.java)) {
            MarketplaceItemDetailsViewModel(marketplaceRepo) as T
        } else {
            throw IllegalArgumentException("ViewModel Class not found")
        }
    }
}