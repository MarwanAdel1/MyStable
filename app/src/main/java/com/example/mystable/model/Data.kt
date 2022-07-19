package com.example.mystable.model

import com.example.mystable.pojo.TabInfo

class Data {
    companion object {
        val tabs = listOf<TabInfo>(
            TabInfo("1", "All"),
            TabInfo("2", "Horse Trading"),
            TabInfo("3", "Used Equipment"),
            TabInfo("4", "Stable for rent")
        )
    }
}