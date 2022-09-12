package com.example.mystable.modules.marketplace_post_details_fragment.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mystable.modules.marketplace_post_details_fragment.domain.usecases.GetPostDetails
import com.example.mystable.modules.marketplace_post_details_fragment.domain.usecases.GetSimilarPosts
import com.example.mystable.modules.marketplace_post_details_fragment.presentation.mapper.PostDetailsUiMapper
import com.example.mystable.modules.marketplace_post_details_fragment.presentation.model.PostDetailsUiModel
import com.example.mystable.modules.marketplace_post_details_fragment.presentation.model.PostSimilarItemsUi
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

    private val itemDataMutableLiveData = MutableLiveData<PostDetailsUiModel?>()
    val itemDataLiveData: LiveData<PostDetailsUiModel?>
        get() = itemDataMutableLiveData

    private var similarItemsMutableLiveData = MutableLiveData<PostSimilarItemsUi?>()
    val similarItemsLiveData: LiveData<PostSimilarItemsUi?>
        get() = similarItemsMutableLiveData


    fun getItemDetails(categoryId: Int, itemId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val data = getPostDetails.execute(categoryId, itemId)

            itemDataMutableLiveData.postValue(PostDetailsUiMapper.toPostDetailsUiModel(data))
        }
    }

    fun getSimilarItems(id: Int) {
        categoryDetailsJob?.cancel()
        categoryDetailsJob = viewModelScope.launch(Dispatchers.IO) {
            val details = getSimilarPosts.execute(id)

            similarItemsMutableLiveData.postValue(PostDetailsUiMapper.toPostSimilarItemUiModel(details))
        }
    }
}