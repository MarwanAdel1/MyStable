package com.example.mystable.model

import com.example.mystable.pojo.TabDetails
import com.example.mystable.pojo.TabInfo
import com.example.mystable.pojo.TabItems

class MarketPlaceDataSource {
    companion object {
        val imageUrl = "https://media.istockphoto.com/photos/the-bay-horse-gallops-on-the-grass-picture-id1209008843?s=612x612"

        val tabs = listOf<TabInfo>(
            TabInfo("1", "All"),
            TabInfo("2", "Horse Trading"),
            TabInfo("3", "Used Equipment"),
            TabInfo("4", "Stable for rent")
        )

        //id 2 is excluded
        val tabsDetails = listOf<TabDetails>(
            TabDetails(
                "5",
                listOf(
                    TabItems("5", "ID5", "", "USD", 99.5),
                )
            ),
            TabDetails(
                "4",
                listOf(
                    TabItems("5", "ID4", "", "USD", 99.5),
                )
            ),
            TabDetails(
                "3",
                listOf(
                    TabItems("5", "ID3", "", "USD", 99.5),
                )
            ),
            TabDetails(
                "6",
                listOf(
                    TabItems("5", "ID6", "", "USD", 99.5),
                )
            ),
            TabDetails(
                "20",
                listOf(
                    TabItems("5", "ID20", "", "USD", 99.5),
                )
            ),
            TabDetails(
                "7",
                listOf(
                    TabItems("1", "ID7", "", "USD", 99.5),
                    TabItems("2", "ID7", "", "USD", 99.5),
                )
            ),
            TabDetails(
                "1",
                listOf(
                    TabItems("5", "ID1", "", "USD", 99.5),
                    TabItems("1", "ID1", "", "USD", 99.5),
                    TabItems("2", "ID1", "", "USD", 99.5),
                    TabItems("3", "ID1", "", "USD", 99.5),
                    TabItems("4", "ID1", "", "USD", 99.5),
                    TabItems("6", "ID1", "", "USD", 99.5),
                    TabItems("7", "ID1", "", "USD", 99.5),
                    TabItems("8", "ID1", "", "USD", 99.5),
                ),
            ),
        )
    }
}