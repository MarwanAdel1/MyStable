package com.example.mystable.screens.marketplace_item_details_fragment.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mystable.model.IMarketplaceRepo
import com.example.mystable.pojo.ItemDetails
import com.example.mystable.pojo.ItemSimilarItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MarketplaceItemDetailsViewModel(private val marketplaceRepo: IMarketplaceRepo) : ViewModel() {
    private var categoryDetailsJob: Job? = null

    private val itemDataMutableLiveData = MutableLiveData<ItemDetails?>()
    val itemDataLiveData: LiveData<ItemDetails?>
        get() = itemDataMutableLiveData

    private var similarItemsMutableLiveData = MutableLiveData<ItemSimilarItem?>()
    val similarItemsLiveData: LiveData<ItemSimilarItem?>
        get() = similarItemsMutableLiveData


    fun getItemDetails(categoryId: Int, itemId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val data = marketplaceRepo.getItemDetails(categoryId, itemId)

            itemDataMutableLiveData.postValue(data)
        }
    }

    fun getSimilarItems(id: Int) {
        categoryDetailsJob?.cancel()
        categoryDetailsJob = viewModelScope.launch(Dispatchers.IO) {
            val details = marketplaceRepo.getSimilarItems(id)

            similarItemsMutableLiveData.postValue(details)
        }
    }
}