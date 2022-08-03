package com.example.mystable.model

import com.example.mystable.pojo.Category
import com.example.mystable.pojo.CategoryDetails
import com.example.mystable.pojo.CategoryItemData

object DataSource {
    const val imageUrl =
        "https://media.istockphoto.com/photos/the-bay-horse-gallops-on-the-grass-picture-id1209008843?s=612x612"
    private const val ownerImage =
        "https://media.istockphoto.com/vectors/default-avatar-photo-placeholder-icon-grey-profile-picture-business-vector-id1327592506?s=612x612"

    val categories = listOf(
        Category(id = 1, name = "All"),
        Category(id = 2, name = "Horse Trading"),
        Category(id = 3, name = "Used Equipment"),
        Category(id = 4, name = "Stable for rent")
    )

    //id 2 is excluded
    val CategoryDetails = listOf(
        CategoryDetails(
            id = 5,
            categoryItemData = listOf(
                CategoryItemData(
                    id = 5,
                    name = "Denvar",
                    imageUrl = imageUrl,
                    currencySymbol = "USD",
                    price = 99.5
                ),
            )
        ),
        CategoryDetails(
            id = 4,
            categoryItemData = listOf(
                CategoryItemData(
                    id = 5,
                    name = "Denvaro",
                    imageUrl = imageUrl,
                    currencySymbol = "USD",
                    price = 99.5
                ),
            )
        ),
        CategoryDetails(
            id = 3,
            categoryItemData = listOf(
                CategoryItemData(
                    id = 5,
                    name = "Denvary",
                    imageUrl = imageUrl,
                    currencySymbol = "USD",
                    price = 99.5
                ),
            )
        ),
        CategoryDetails(
            id = 6,
            categoryItemData = listOf(
                CategoryItemData(
                    id = 5,
                    name = "Denvar",
                    imageUrl = imageUrl,
                    currencySymbol = "USD",
                    price = 99.5
                ),
            )
        ),
        CategoryDetails(
            id = 20,
            categoryItemData = listOf(
                CategoryItemData(
                    id = 5,
                    name = "Denvar",
                    imageUrl = imageUrl,
                    currencySymbol = "USD",
                    price = 99.5
                ),
            )
        ),
        CategoryDetails(
            id = 7,
            categoryItemData = listOf(
                CategoryItemData(
                    id = 1,
                    name = "Denvar",
                    imageUrl = imageUrl,
                    currencySymbol = "USD",
                    price = 99.5
                ),
                CategoryItemData(
                    id = 2,
                    name = "Denvar",
                    imageUrl = imageUrl,
                    currencySymbol = "USD",
                    price = 99.5
                ),
            )
        ),
        CategoryDetails(
            id = 1,
            categoryItemData = listOf(
                CategoryItemData(
                    id = 5,
                    name = "Denvar1",
                    imageUrl = imageUrl,
                    currencySymbol = "USD",
                    price = 99.5
                ),
                CategoryItemData(
                    id = 1,
                    name = "Denvar2",
                    imageUrl = imageUrl,
                    currencySymbol = "USD",
                    price = 99.5
                ),
                CategoryItemData(
                    id = 2,
                    name = "Denvar3",
                    imageUrl = imageUrl,
                    currencySymbol = "USD",
                    price = 99.5
                ),
                CategoryItemData(
                    id = 3,
                    name = "Denvar4",
                    imageUrl = imageUrl,
                    currencySymbol = "USD",
                    price = 99.5
                ),
                CategoryItemData(
                    id = 4,
                    name = "Denvar5",
                    imageUrl = imageUrl,
                    currencySymbol = "USD",
                    price = 99.5
                ),
                CategoryItemData(
                    id = 6,
                    name = "Denvar6",
                    imageUrl = imageUrl,
                    currencySymbol = "USD",
                    price = 99.5
                ),
                CategoryItemData(
                    id = 7,
                    name = "Denvar7",
                    imageUrl = imageUrl,
                    currencySymbol = "USD",
                    price = 99.5
                ),
                CategoryItemData(
                    id = 8,
                    name = "Denvar8",
                    imageUrl = imageUrl,
                    currencySymbol = "USD",
                    price = 99.5
                ),
            ),
        ),
    )



}
