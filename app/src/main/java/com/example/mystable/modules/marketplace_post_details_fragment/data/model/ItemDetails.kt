package com.example.mystable.modules.marketplace_post_details_fragment.data.model

import com.squareup.moshi.Json

data class ItemDetails(
    @Json(name = "categoryId")
    val categoryId: Int,
    @Json(name = "itemId")
    val itemId: Int,
    @Json(name = "itemData")
    val itemData: List<ICategoryItemsData>
)
