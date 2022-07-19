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
        delay(10000)
        return Data.tabs
    }

    suspend fun getEmptyTabsInfo(): List<TabInfo> {
        delay(10000)
        return emptyList()
    }

    suspend fun getTabDetails(): List<TabDetails> {
        delay(10000)
        return emptyList()
    }

    suspend fun getEmptyTabDetails(): List<TabDetails> {
        delay(10000)
        return emptyList()
    }
}