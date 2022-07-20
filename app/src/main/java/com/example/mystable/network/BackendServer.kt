package com.example.mystable.network

import com.example.mystable.model.Data
import com.example.mystable.pojo.TabDetails
import com.example.mystable.pojo.TabInfo
import kotlinx.coroutines.delay

class BackendServer private constructor() {
    companion object {
        private var backendServer: BackendServer? = null

        fun getInstance(): BackendServer {
            return backendServer ?: BackendServer()
        }
    }

    suspend fun getTabsInfo(): List<TabInfo> {
        delay(5000)
        return Data.tabs
    }

    suspend fun getEmptyTabsInfo(): List<TabInfo> {
        delay(5000)
        return emptyList()
    }

    suspend fun getTabDetails(id: String): TabDetails? {
        val details = getTabDetailsById(id)
        delay(5000)
        return details
    }

    // simulate backend server respond with a one tab details depends on tab clicked (tab id) not all tabs
    private fun getTabDetailsById(id: String): TabDetails? {
        var details: TabDetails? = null

        for (tabDetails in Data.tabsDetails) {
            if (tabDetails.id == id) {
                details = tabDetails
                break
            }
        }
        return details
    }
}