package com.example.mystable.modules.marketplace_post_details_fragment.data.model

import com.squareup.moshi.Json
import java.util.*

data class ItemEssentialInfo(
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "price")
    val price: Double,
    @Json(name = "endDate")
    val endDate: Date,
    @Json(name = "currencySymbol")
    val currencySymbol: String
) : ICategoryItemsData
