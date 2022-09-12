package com.example.mystable.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mystable.modules.marketplace_post_details_fragment.presentation.viewmodel.MarketplaceItemDetailsViewModel
import com.example.mystable.modules.marketplace_posts_fragment.presentation.viewmodel.MarketPlaceViewModel
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
