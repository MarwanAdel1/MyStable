package com.example.mystable.modules.marketplace_posts_fragment.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mystable.modules.marketplace_posts_fragment.domain.usecases.GetCategories
import com.example.mystable.modules.marketplace_posts_fragment.domain.usecases.GetCategoryPosts
import com.example.mystable.modules.marketplace_posts_fragment.presentation.mapper.CategoryUiMapper
import com.example.mystable.modules.marketplace_posts_fragment.presentation.mapper.PostsUiMapper
import com.example.mystable.modules.marketplace_posts_fragment.presentation.model.CategoryPostsUiModel
import com.example.mystable.modules.marketplace_posts_fragment.presentation.model.CategoryUiModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

class MarketPlaceViewModel @Inject constructor(
    private val getCategories: GetCategories,
    private val getCategoryPosts: GetCategoryPosts
) : ViewModel() {
    init {
        getAllCategory(false) // true for getting data - false for getting no data
    }

    private val selectedCategoryByRowIndexMutableLiveData = MutableLiveData<Int>()
    val selectedCategoryByRowIndexLiveData: LiveData<Int>
        get() = selectedCategoryByRowIndexMutableLiveData

    private val categoryMutableLiveData = MutableLiveData<List<CategoryUiModel>>()
    val categoryLiveData: LiveData<List<CategoryUiModel>>
        get() = categoryMutableLiveData

    private val categoryItemsMutableLiveData = MutableLiveData<CategoryPostsUiModel?>()
    val categoryItemsLiveData: LiveData<CategoryPostsUiModel?>
        get() = categoryItemsMutableLiveData

    private var categoryDetailsJob: Job? = null

    fun getAllCategory(flag: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            val tabs = getCategories.execute(flag)

            categoryMutableLiveData.postValue(CategoryUiMapper.categoryToUiModel(tabs))
            if (tabs.isNotEmpty()) {
                setSelectedCategoryIndex(0)
            }
        }
    }

    fun refreshCategoryDetails() {
        selectedCategoryByRowIndexMutableLiveData.value?.let {
            getCategoryDetails(
                getCategoryIdByRowIndex(it)
            )
        }
    }

    fun getCategoryDetails(id: Int) {
        categoryDetailsJob?.cancel()
        categoryDetailsJob = viewModelScope.launch(Dispatchers.IO) {

            val details = getCategoryPosts.execute(id)
            categoryItemsMutableLiveData.postValue(PostsUiMapper.postsToPostsUIModel(details))
        }
    }

    fun setSelectedCategoryIndex(rwoIndex: Int) {
        selectedCategoryByRowIndexMutableLiveData.postValue(rwoIndex)
    }

    private fun getCategoryIdByRowIndex(rowIndex: Int): Int {
        return categoryMutableLiveData.value?.get(rowIndex)!!.id
    }
}