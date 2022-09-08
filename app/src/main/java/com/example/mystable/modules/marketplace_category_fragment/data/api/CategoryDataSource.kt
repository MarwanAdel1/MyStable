package com.example.mystable.modules.marketplace_category_fragment.data.api

import com.example.mystable.modules.marketplace_category_fragment.data.model.Category
import com.example.mystable.modules.marketplace_category_fragment.data.model.CategoryDetails
import com.example.mystable.modules.marketplace_category_fragment.data.model.CategoryItemData
import javax.inject.Inject

class CategoryDataSource @Inject constructor() {
    private val imageUrl =
        "https://media.istockphoto.com/photos/the-bay-horse-gallops-on-the-grass-picture-id1209008843?s=612x612"

    val categories = listOf(
        Category(id = 1, name = "All"),
        Category(id = 2, name = "Horse Trading"),
        Category(id = 3, name = "Used Equipment"),
        Category(id = 4, name = "Stable for rent")
    )

    //id 2 is excluded
    val categoryDetails = listOf(
        CategoryDetails(
            categoryId = 5,
            categoryItemData = listOf(
                CategoryItemData(
                    id = 5,
                    name = "Denver",
                    imageUrl = imageUrl,
                    currencySymbol = "USD",
                    price = 99.5
                ),
            )
        ),
        CategoryDetails(
            categoryId = 4,
            categoryItemData = listOf(
                CategoryItemData(
                    id = 5,
                    name = "Denver",
                    imageUrl = imageUrl,
                    currencySymbol = "USD",
                    price = 99.5
                ),
            )
        ),
        CategoryDetails(
            categoryId = 3,
            categoryItemData = listOf(
                CategoryItemData(
                    id = 5,
                    name = "Denver",
                    imageUrl = imageUrl,
                    currencySymbol = "USD",
                    price = 99.5
                ),
            )
        ),
        CategoryDetails(
            categoryId = 6,
            categoryItemData = listOf(
                CategoryItemData(
                    id = 5,
                    name = "Denver",
                    imageUrl = imageUrl,
                    currencySymbol = "USD",
                    price = 99.5
                ),
            )
        ),
        CategoryDetails(
            categoryId = 20,
            categoryItemData = listOf(
                CategoryItemData(
                    id = 5,
                    name = "Denver",
                    imageUrl = imageUrl,
                    currencySymbol = "USD",
                    price = 99.5
                ),
            )
        ),
        CategoryDetails(
            categoryId = 7,
            categoryItemData = listOf(
                CategoryItemData(
                    id = 1,
                    name = "Denver",
                    imageUrl = imageUrl,
                    currencySymbol = "USD",
                    price = 99.5
                ),
                CategoryItemData(
                    id = 2,
                    name = "Denver",
                    imageUrl = imageUrl,
                    currencySymbol = "USD",
                    price = 99.5
                ),
            )
        ),
        CategoryDetails(
            categoryId = 1,
            categoryItemData = listOf(
                CategoryItemData(
                    id = 5,
                    name = "Denver1",
                    imageUrl = imageUrl,
                    currencySymbol = "USD",
                    price = 99.5
                ),
                CategoryItemData(
                    id = 1,
                    name = "Denver2",
                    imageUrl = imageUrl,
                    currencySymbol = "USD",
                    price = 99.5
                ),
                CategoryItemData(
                    id = 2,
                    name = "Denver3",
                    imageUrl = imageUrl,
                    currencySymbol = "USD",
                    price = 99.5
                ),
                CategoryItemData(
                    id = 3,
                    name = "Denver4",
                    imageUrl = imageUrl,
                    currencySymbol = "USD",
                    price = 99.5
                ),
                CategoryItemData(
                    id = 4,
                    name = "Denver5",
                    imageUrl = imageUrl,
                    currencySymbol = "USD",
                    price = 99.5
                )
            ),
        ),
    )
}
