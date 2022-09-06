package com.example.mystable.presentation.marketplace_item_details_fragment.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mystable.data.model.ItemDetails
import com.example.mystable.data.model.ItemSimilarItem
import com.example.mystable.domain.usecases.GetPostDetails
import com.example.mystable.domain.usecases.GetSimilarPosts
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

class MarketplaceItemDetailsViewModel @Inject constructor(
    private val getPostDetails: GetPostDetails,
    private val getSimilarPosts: GetSimilarPosts
) :
    ViewModel() {
    private var categoryDetailsJob: Job? = null

    private val itemDataMutableLiveData = MutableLiveData<ItemDetails?>()
    val itemDataLiveData: LiveData<ItemDetails?>
        get() = itemDataMutableLiveData

    private var similarItemsMutableLiveData = MutableLiveData<ItemSimilarItem?>()
    val similarItemsLiveData: LiveData<ItemSimilarItem?>
        get() = similarItemsMutableLiveData


    fun getItemDetails(categoryId: Int, itemId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val data = getPostDetails.execute(categoryId, itemId)

            itemDataMutableLiveData.postValue(data)
        }
    }

    fun getSimilarItems(id: Int) {
        categoryDetailsJob?.cancel()
        categoryDetailsJob = viewModelScope.launch(Dispatchers.IO) {
            val details = getSimilarPosts.execute(id)

            similarItemsMutableLiveData.postValue(details)
        }
    }
}