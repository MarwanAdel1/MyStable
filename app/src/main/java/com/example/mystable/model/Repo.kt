package com.example.mystable.model

import com.example.mystable.network.BackendServer
import com.example.mystable.pojo.TabDetails
import com.example.mystable.pojo.TabInfo

class Repo private constructor(private val backendServer: BackendServer) : IMarketplaceRepo {
    companion object {
        private var repo: Repo? = null

        fun getInstance(backendServer: BackendServer): Repo {
            return repo ?: Repo(backendServer)
        }
    }

    override suspend fun getTabsInfo(): List<TabInfo> {
        return backendServer.getTabsInfo()
    }

    override suspend fun getTabDetails(id: String): TabDetails? {
        return backendServer.getTabDetails(id)
    }

    override suspend fun getEmptyTabsInfo(): List<TabInfo> {
        return backendServer.getEmptyTabsInfo()
    }
}