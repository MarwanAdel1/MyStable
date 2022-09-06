package com.example.mystable.data.api

import com.example.mystable.data.model.*
import com.google.android.gms.maps.model.LatLng
import java.util.*
import javax.inject.Inject

class DataSource @Inject constructor() {
    private val imageUrl =
        "https://media.istockphoto.com/photos/the-bay-horse-gallops-on-the-grass-picture-id1209008843?s=612x612"
    private val ownerImage =
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

    val categoryItemsDetails = listOf(
        ItemDetails(
            categoryId = 5,
            itemId = 5,
            itemData = listOf(
                ItemEssentialInfo(
                    id = 5,
                    name = "Denver",
                    currencySymbol = "USD",
                    price = 99.5,
                    endDate = getDate(2)
                ),
                ItemDescription(
                    description = "Lorem Ipsum is simply dummy text of the print and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown ."
                ),
                ItemImages(
                    imageUrl = listOf(
                        imageUrl,
                        imageUrl,
                        imageUrl,
                        imageUrl
                    )
                ),
                ItemInfo(
                    infoStatus = true,
                    info = mapOf<String, Any>(
                        Pair("Horse name", "Denver"),
                        Pair("Horse color", "Black"),
                        Pair("Horse gender", "Gender"),
                        Pair("Horse sex type", "Male"),
                        Pair("Date of birth", getDate(-5)),
                        Pair("Horse Breed", "Horse Breed"),
                        Pair("Horse Strain", "Horse Strain")
                    )
                ),
                ItemLocation(
                    locationDescription = "Lorem Ipsum is simply dummy text of the print and typesetting industry.",
                    location = LatLng(
                        31.245928,
                        29.965221
                    )
                ),
                ItemOwner(
                    soldStatus = true,
                    owner = ItemOwnerInfo(
                        ownerName = "Marwan Adel",
                        ownerDesc = "Owner",
                        ownerChat = "",
                        ownerChatAvailability = false,
                        ownerEmail = "marwan@gmail.com",
                        ownerImage = ownerImage,
                        ownerPhone = "01279444120"
                    )
                )
            )
        ),
        ItemDetails(
            categoryId = 4,
            itemId = 5,
            itemData = listOf(
                ItemEssentialInfo(
                    id = 5,
                    name = "Denver",
                    currencySymbol = "USD",
                    price = 99.5,
                    endDate = getDate(2)
                ),
                ItemDescription(
                    description = "Lorem Ipsum is simply dummy text of the print and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown ."
                ),
                ItemImages(
                    imageUrl = listOf(
                        imageUrl
                    )
                ),
                ItemInfo(
                    infoStatus = true,
                    info = mapOf<String, Any>(
                        Pair("Horse name", "Denver"),
                        Pair("Horse color", "Black"),
                        Pair("Horse gender", "Gender"),
                        Pair("Horse sex type", "Male"),
                        Pair("Date of birth", getDate(-5)),
                        Pair("Horse Breed", "Horse Breed"),
                        Pair("Horse Strain", "Horse Strain")
                    )
                ),
                ItemLocation(
                    locationDescription = "Lorem Ipsum is simply dummy text of the print and typesetting industry.",
                    location = LatLng(
                        31.245928,
                        29.965221
                    )
                ),
                ItemOwner(
                    soldStatus = false,
                    owner = ItemOwnerInfo(
                        ownerName = "Marwan Adel",
                        ownerDesc = "Owner",
                        ownerChat = "",
                        ownerChatAvailability = false,
                        ownerEmail = "marwan@gmail.com",
                        ownerImage = ownerImage,
                        ownerPhone = "01279444120"
                    )
                )
            )
        ),
        ItemDetails(
            categoryId = 3,
            itemId = 5,
            itemData = listOf(
                ItemEssentialInfo(
                    id = 5,
                    name = "Denver",
                    currencySymbol = "USD",
                    price = 99.5,
                    endDate = getDate(2),
                ),
                ItemDescription(
                    description = "Lorem Ipsum is simply dummy text of the print and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown ."
                ),
                ItemImages(
                    imageUrl = listOf(
                        imageUrl,
                        imageUrl,
                        imageUrl,
                        imageUrl
                    ),
                ),
                ItemInfo(
                    infoStatus = true,
                    info = mapOf<String, Any>(
                        Pair("Horse name", "Denver"),
                        Pair("Horse color", "Black"),
                        Pair("Horse gender", "Gender"),
                        Pair("Horse sex type", "Male"),
                        Pair("Date of birth", getDate(-5)),
                        Pair("Horse Breed", "Horse Breed"),
                        Pair("Horse Strain", "Horse Strain")
                    )
                ),
                ItemLocation(
                    locationDescription = "Lorem Ipsum is simply dummy text of the print and typesetting industry.",
                    location = LatLng(
                        31.245928,
                        29.965221
                    )
                ),
                ItemOwner(
                    soldStatus = false,
                    owner = ItemOwnerInfo(
                        ownerName = "Marwan Adel",
                        ownerDesc = "Owner",
                        ownerChat = "",
                        ownerChatAvailability = false,
                        ownerEmail = "marwan@gmail.com",
                        ownerImage = ownerImage,
                        ownerPhone = "01279444120"
                    )
                )
            )
        ),
        ItemDetails(
            categoryId = 1,
            itemId = 5,
            itemData = listOf(
                ItemEssentialInfo(
                    id = 5,
                    name = "Denver1",
                    currencySymbol = "USD",
                    price = 99.5,
                    endDate = getDate(2)
                ),
                ItemDescription(
                    description = "Lorem Ipsum is simply dummy text of the print and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown ."
                ),
                ItemImages(
                    imageUrl = listOf(
                        imageUrl,
                        imageUrl,
                        imageUrl
                    ),
                ),
                ItemLocation(
                    locationDescription = "Lorem Ipsum is simply dummy text of the print and typesetting industry.",
                    location = LatLng(
                        31.245928,
                        29.965221
                    )
                ),
                ItemOwner(
                    soldStatus = true,
                    owner = ItemOwnerInfo(
                        ownerName = "Marwan Adel",
                        ownerDesc = "Owner",
                        ownerChat = "",
                        ownerChatAvailability = false,
                        ownerEmail = "marwan@gmail.com",
                        ownerImage = ownerImage,
                        ownerPhone = "01279444120"
                    )
                )
            )
        ),
        ItemDetails(
            categoryId = 1,
            itemId = 1,
            itemData = listOf(
                ItemEssentialInfo(
                    id = 1,
                    name = "Denver2",
                    currencySymbol = "USD",
                    price = 99.5,
                    endDate = getDate(2)
                ),
                ItemDescription(
                    description = "Lorem Ipsum is simply dummy text of the print and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown ."
                ),
                ItemImages(
                    imageUrl = listOf(
                        imageUrl
                    ),
                ),
                ItemInfo(
                    infoStatus = true,
                    info = mapOf<String, Any>(
                        Pair("Horse name", "Denver2"),
                        Pair("Horse color", "Black"),
                        Pair("Horse gender", "Gender"),
                        Pair("Horse sex type", "Male"),
                        Pair("Date of birth", getDate(-5)),
                        Pair("Horse Breed", "Horse Breed"),
                        Pair("Horse Strain", "Horse Strain")
                    )
                ),
                ItemLocation(
                    locationDescription = "Lorem Ipsum is simply dummy text of the print and typesetting industry.",
                    location = LatLng(
                        31.245928,
                        29.965221
                    )
                ),
                ItemOwner(
                    soldStatus = false,
                    owner = ItemOwnerInfo(
                        ownerName = "Marwan Adel",
                        ownerDesc = "Owner",
                        ownerChat = "",
                        ownerChatAvailability = false,
                        ownerEmail = "marwan@gmail.com",
                        ownerImage = ownerImage,
                        ownerPhone = "01279444120"
                    )
                )
            )
        ),
        ItemDetails(
            categoryId = 1,
            itemId = 2,
            itemData = listOf(
                ItemEssentialInfo(
                    id = 2,
                    name = "Denver3",
                    currencySymbol = "USD",
                    price = 99.5,
                    endDate = getDate(2),
                ),
                ItemDescription(
                    description = "Lorem Ipsum is simply dummy text of the print and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown ."
                ),
                ItemImages(
                    imageUrl = listOf(
                        imageUrl
                    ),
                ),
                ItemInfo(
                    infoStatus = false,
                    info = null
                ),
                ItemLocation(
                    locationDescription = "Lorem Ipsum is simply dummy text of the print and typesetting industry.",
                    location = LatLng(
                        31.245928,
                        29.965221
                    )
                ),
                ItemOwner(
                    soldStatus = false,
                    owner = ItemOwnerInfo(
                        ownerName = "Marwan Adel",
                        ownerDesc = "Owner",
                        ownerChat = "",
                        ownerChatAvailability = false,
                        ownerEmail = "marwan@gmail.com",
                        ownerImage = ownerImage,
                        ownerPhone = "01279444120"
                    )
                )
            )
        ),
        ItemDetails(
            categoryId = 1,
            itemId = 3,
            itemData = listOf(
                ItemEssentialInfo(
                    id = 3,
                    name = "Denver4",
                    currencySymbol = "USD",
                    price = 99.5,
                    endDate = getDate(2)
                ),
                ItemDescription(
                    description = "Lorem Ipsum is simply dummy text of the print and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown ."
                ),
                ItemImages(
                    imageUrl = listOf(
                        imageUrl
                    ),
                ),
                ItemInfo(
                    infoStatus = true,
                    info = mapOf<String, Any>(
                        Pair("Horse name", "Denver4"),
                        Pair("Horse color", "Black"),
                        Pair("Horse gender", "Gender"),
                        Pair("Horse sex type", "Male"),
                        Pair("Date of birth", getDate(-5)),
                        Pair("Horse Breed", "Horse Breed"),
                        Pair("Horse Strain", "Horse Strain")
                    )
                ),
                ItemLocation(
                    locationDescription = "Lorem Ipsum is simply dummy text of the print and typesetting industry.",
                    location = LatLng(
                        31.245928,
                        29.965221
                    )
                ),
                ItemOwner(
                    soldStatus = false,
                    owner = ItemOwnerInfo(
                        ownerName = "Marwan Adel",
                        ownerDesc = "Owner",
                        ownerChat = "",
                        ownerChatAvailability = false,
                        ownerEmail = "marwan@gmail.com",
                        ownerImage = ownerImage,
                        ownerPhone = "01279444120"
                    )
                )
            )
        ),
        ItemDetails(
            categoryId = 1,
            itemId = 4,
            itemData = listOf(
                ItemEssentialInfo(
                    id = 4,
                    name = "Denver5",
                    currencySymbol = "USD",
                    price = 99.5,
                    endDate = getDate(2)
                ),
                ItemDescription(
                    description = "Lorem Ipsum is simply dummy text of the print and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown ."
                ),
                ItemImages(
                    imageUrl = listOf(
                        imageUrl
                    ),
                ),
                ItemInfo(
                    infoStatus = true,
                    info = mapOf<String, Any>(
                        Pair("Horse name", "Denver5"),
                        Pair("Horse color", "Black"),
                        Pair("Horse gender", "Gender"),
                        Pair("Horse sex type", "Male"),
                        Pair("Date of birth", getDate(-5)),
                        Pair("Horse Breed", "Horse Breed"),
                        Pair("Horse Strain", "Horse Strain")
                    )
                ),
                ItemLocation(
                    locationDescription = "Lorem Ipsum is simply dummy text of the print and typesetting industry.",
                    location = LatLng(
                        31.245928,
                        29.965221
                    )
                ),
                ItemOwner(
                    soldStatus = false,
                    owner = ItemOwnerInfo(
                        ownerName = "Marwan Adel",
                        ownerDesc = "Owner",
                        ownerChat = "",
                        ownerChatAvailability = false,
                        ownerEmail = "marwan@gmail.com",
                        ownerImage = ownerImage,
                        ownerPhone = "01279444120"
                    )
                )
            )
        )
    )


    private fun getDate(monthsNumbers: Int): Date {
        val calendar = Calendar.getInstance()
        calendar.set(
            Calendar.MONTH,
            (calendar.get(Calendar.MONTH) + monthsNumbers)
        )
        return calendar.time
    }
}
