package com.example.mystable.screens.marketplace_fragment.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mystable.model.IMarketplaceRepo
import com.example.mystable.pojo.TabDetails
import com.example.mystable.pojo.TabInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MarketPlaceViewModel(private val marketplaceRepo: IMarketplaceRepo) : ViewModel() {
    private var tabsInfoMutableLiveData = MutableLiveData<List<TabInfo>>()
    val tabsInfoLiveData: LiveData<List<TabInfo>>
        get() = tabsInfoMutableLiveData

    private var tabDetailsMutableLiveData = MutableLiveData<TabDetails>()
    val tabDetailsLiveData: LiveData<TabDetails>
        get() = tabDetailsMutableLiveData

    fun getTabsInfo(flag: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            val tabs =
                if (flag) marketplaceRepo.getTabsInfo() else marketplaceRepo.getEmptyTabsInfo()
            withContext(Dispatchers.Main) {
                tabsInfoMutableLiveData.postValue(tabs)
            }
        }
    }

    fun getTabDetails(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val details = marketplaceRepo.getTabDetails(id)
            withContext(Dispatchers.Main) {
                tabDetailsMutableLiveData.postValue(details)
            }
        }
    }
}