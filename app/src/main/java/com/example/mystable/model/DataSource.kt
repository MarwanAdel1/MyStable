package com.example.mystable.model

import com.example.mystable.pojo.Category
import com.example.mystable.pojo.CategoryDetails
import com.example.mystable.pojo.CategoryDetailsItems

object DataSource {

    const val imageUrl =
        "https://media.istockphoto.com/photos/the-bay-horse-gallops-on-the-grass-picture-id1209008843?s=612x612"

    val tabs = listOf(
        Category("1", "All"),
        Category("2", "Horse Trading"),
        Category("3", "Used Equipment"),
        Category("4", "Stable for rent")
    )

    //id 2 is excluded
    val tabsDetails = listOf(
        CategoryDetails(
            "5",
            listOf(
                CategoryDetailsItems("5", "ID5", "", "USD", 99.5),
            )
        ),
        CategoryDetails(
            "4",
            listOf(
                CategoryDetailsItems("5", "ID4", "", "USD", 99.5),
            )
        ),
        CategoryDetails(
            "3",
            listOf(
                CategoryDetailsItems("5", "ID3", "", "USD", 99.5),
            )
        ),
        CategoryDetails(
            "6",
            listOf(
                CategoryDetailsItems("5", "ID6", "", "USD", 99.5),
            )
        ),
        CategoryDetails(
            "20",
            listOf(
                CategoryDetailsItems("5", "ID20", "", "USD", 99.5),
            )
        ),
        CategoryDetails(
            "7",
            listOf(
                CategoryDetailsItems("1", "ID7", "", "USD", 99.5),
                CategoryDetailsItems("2", "ID7", "", "USD", 99.5),
            )
        ),
        CategoryDetails(
            "1",
            listOf(
                CategoryDetailsItems("5", "ID1", "", "USD", 99.5),
                CategoryDetailsItems("1", "ID1", "", "USD", 99.5),
                CategoryDetailsItems("2", "ID1", "", "USD", 99.5),
                CategoryDetailsItems("3", "ID1", "", "USD", 99.5),
                CategoryDetailsItems("4", "ID1", "", "USD", 99.5),
                CategoryDetailsItems("6", "ID1", "", "USD", 99.5),
                CategoryDetailsItems("7", "ID1", "", "USD", 99.5),
                CategoryDetailsItems("8", "ID1", "", "USD", 99.5),
            ),
        ),
    )
}
