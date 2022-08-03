package com.example.mystable.model

import com.example.mystable.pojo.*
import com.google.android.gms.maps.model.LatLng
import java.util.*

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
                    name = "Denvar",
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
                    info = ItemInfoDetails(
                        name = "Denvar",
                        color = "Black",
                        gender = "Gender",
                        sexType = "Male",
                        breed = "Horse Breed",
                        strain = "Horse Strain",
                        dob = getDate(-5)
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
                    name = "Denvar",
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
                    info = ItemInfoDetails(
                        name = "Denvar",
                        color = "Black",
                        gender = "Gender",
                        sexType = "Male",
                        breed = "Horse Breed",
                        strain = "Horse Strain",
                        dob = getDate(-5)
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
                    name = "Denvar",
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
                    info = ItemInfoDetails(
                        name = "Denvar",
                        color = "Black",
                        gender = "Gender",
                        sexType = "Male",
                        breed = "Horse Breed",
                        strain = "Horse Strain",
                        dob = getDate(-5)
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
                    name = "Denvar1",
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
                    soldStatus = true,
                    owner = ItemOwnerInfo(
                        ownerName = "Marwan Adel",
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
                    name = "Denvar2",
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
                    info = ItemInfoDetails(
                        name = "Denvar2",
                        color = "Black",
                        gender = "Gender",
                        sexType = "Male",
                        breed = "Horse Breed",
                        strain = "Horse Strain",
                        dob = getDate(-5)
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
                    name = "Denvar3",
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
                    name = "Denvar4",
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
                    info = ItemInfoDetails(
                        name = "Denvar4",
                        color = "Black",
                        gender = "Gender",
                        sexType = "Male",
                        breed = "Horse Breed",
                        strain = "Horse Strain",
                        dob = getDate(-5)
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
                    name = "Denvar5",
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
                    info = ItemInfoDetails(
                        name = "Denvar5",
                        color = "Black",
                        gender = "Gender",
                        sexType = "Male",
                        breed = "Horse Breed",
                        strain = "Horse Strain",
                        dob = getDate(-5)
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
        calendar.set(Calendar.MONTH, (calendar.get(Calendar.MONTH) + monthsNumbers))
        return calendar.time
    }
}
