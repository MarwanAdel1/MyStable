package com.example.mystable.model

import com.example.mystable.pojo.TabDetails
import com.example.mystable.pojo.TabItems
import com.example.mystable.pojo.TabInfo

interface IMarketplaceRepo {
    suspend fun getTabsInfo(): List<TabInfo>
    suspend fun getTabDetails(id: String): TabDetails?

    suspend fun getEmptyTabsInfo(): List<TabInfo>
}