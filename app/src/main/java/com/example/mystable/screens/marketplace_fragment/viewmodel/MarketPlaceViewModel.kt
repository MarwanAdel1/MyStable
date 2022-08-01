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
    private val selectedCategoryMutableLiveData = MutableLiveData<String>()
    val selectedCategoryLiveData: LiveData<String>
        get() = selectedCategoryMutableLiveData

    private val categoryMutableLiveData = MutableLiveData<List<Category>>()
    val categoryLiveData: LiveData<List<Category>>
        get() = categoryMutableLiveData

    private val categoryDetailsMutableLiveData = MutableLiveData<CategoryDetails?>()
    val categoryDetailsLiveData: LiveData<CategoryDetails?>
        get() = categoryDetailsMutableLiveData

    private var categoryDetailsJob: Job? = null

    fun getCategory(flag: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            val tabs = marketplaceRepo.getCategories(flag)

            categoryMutableLiveData.postValue(tabs)
            selectedCategoryMutableLiveData.postValue("0")
        }
    }

    fun refreshCategoryDetails() {
        selectedCategoryMutableLiveData.value?.let { getCategoryDetails(it) }
    }

    fun getCategoryDetails(id: String) {
        categoryDetailsJob?.cancel()
        setSelectedCategoryId(id)
        categoryDetailsJob = viewModelScope.launch(Dispatchers.IO) {
            val details = marketplaceRepo.getCategoryDetails(id)

            categoryDetailsMutableLiveData.postValue(details)
        }
    }

    private fun setSelectedCategoryId(id: String) {
        selectedCategoryMutableLiveData.postValue(id)
    }
}