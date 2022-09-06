package com.example.mystable.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mystable.presentation.marketplace_fragment.viewmodel.MarketPlaceViewModel
import com.example.mystable.presentation.marketplace_item_details_fragment.viewmodel.MarketplaceItemDetailsViewModel
import javax.inject.Inject

class DaggerViewModelFactory @Inject constructor(
    private val viewModelsMap: Map<Class<out ViewModel>,
            @JvmSuppressWildcards ViewModel>
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MarketPlaceViewModel::class.java)) {
            return viewModelsMap[MarketPlaceViewModel::class.java] as T
        } else if (modelClass.isAssignableFrom(MarketplaceItemDetailsViewModel::class.java)) {
            return viewModelsMap[MarketplaceItemDetailsViewModel::class.java] as T
        }

        throw IllegalArgumentException("Unknown model class")
    }
}
