package com.example.mystable.screens.marketplace_fragment.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mystable.model.IMarketplaceRepo
import com.example.mystable.pojo.TabInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MarketPlaceViewModel(private val marketplaceRepo: IMarketplaceRepo) : ViewModel() {
    private var tabsInfoMutableLiveData = MutableLiveData<List<TabInfo>>()
    val tabsInfoLiveData: LiveData<List<TabInfo>>
        get() = tabsInfoMutableLiveData

    fun getTabsInfo(flag: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            val orders =
                if (flag) marketplaceRepo.getTabsInfo() else marketplaceRepo.getEmptyTabsInfo()
            withContext(Dispatchers.Main) {
                tabsInfoMutableLiveData.postValue(orders)
            }
        }
    }
}