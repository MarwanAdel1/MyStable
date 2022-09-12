package com.example.mystable.modules.marketplace_posts_fragment.data.model

import com.squareup.moshi.Json

data class CategoryItemData(
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "imageUrl")
    val imageUrl: String,
    @Json(name = "currencySymbol")
    val currencySymbol: String,
    @Json(name = "price")
    val price: Double
)
