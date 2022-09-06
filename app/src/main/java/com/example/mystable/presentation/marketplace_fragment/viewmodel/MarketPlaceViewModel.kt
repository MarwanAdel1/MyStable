package com.example.mystable.presentation.marketplace_fragment.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mystable.data.model.Category
import com.example.mystable.data.model.CategoryDetails
import com.example.mystable.domain.usecases.GetCategories
import com.example.mystable.domain.usecases.GetCategoryPosts
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

    private val categoryMutableLiveData = MutableLiveData<List<Category>>()
    val categoryLiveData: LiveData<List<Category>>
        get() = categoryMutableLiveData

    private val categoryItemsMutableLiveData = MutableLiveData<CategoryDetails?>()
    val categoryItemsLiveData: LiveData<CategoryDetails?>
        get() = categoryItemsMutableLiveData

    private var categoryDetailsJob: Job? = null

    fun getAllCategory(flag: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            val tabs = getCategories.execute(flag)

            categoryMutableLiveData.postValue(tabs)
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
            categoryItemsMutableLiveData.postValue(details)
        }
    }

    fun setSelectedCategoryIndex(rwoIndex: Int) {
        selectedCategoryByRowIndexMutableLiveData.postValue(rwoIndex)
    }

    private fun getCategoryIdByRowIndex(rowIndex: Int): Int {
        return categoryMutableLiveData.value?.get(rowIndex)!!.id
    }
}