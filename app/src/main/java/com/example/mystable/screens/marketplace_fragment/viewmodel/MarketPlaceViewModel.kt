package com.example.mystable.screens.marketplace_fragment.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mystable.model.IMarketplaceRepo
import com.example.mystable.pojo.Category
import com.example.mystable.pojo.CategoryDetails
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MarketPlaceViewModel(private val marketplaceRepo: IMarketplaceRepo) : ViewModel() {
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
            val tabs = marketplaceRepo.getCategories(flag)

            categoryMutableLiveData.postValue(tabs)
            if (tabs.isNotEmpty()) {
                selectedCategoryByRowIndexMutableLiveData.postValue(0)
            }
        }
    }

    fun refreshCategoryDetails() {
        selectedCategoryByRowIndexMutableLiveData.value?.let {
            getCategoryDetails(
                getCategoryId(it),
                it
            )
        }
    }

    private fun getCategoryId(rowIndex: Int): Int {
        return categoryMutableLiveData.value?.get(rowIndex)!!.id
    }

    fun getCategoryDetails(id: Int, rowIndex: Int) {
        categoryDetailsJob?.cancel()
        setSelectedCategoryId(id)
        categoryDetailsJob = viewModelScope.launch(Dispatchers.IO) {
            val details = marketplaceRepo.getCategoryDetails(id)

            categoryItemsMutableLiveData.postValue(details)
            selectedCategoryByRowIndexMutableLiveData.postValue(rowIndex)
        }
    }

    private fun setSelectedCategoryId(id: Int) {
        selectedCategoryByRowIndexMutableLiveData.postValue(id)
    }
}