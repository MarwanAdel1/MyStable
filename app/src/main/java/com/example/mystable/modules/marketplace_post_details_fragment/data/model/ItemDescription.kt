package com.example.mystable.modules.marketplace_post_details_fragment.data.model

import com.squareup.moshi.Json

data class ItemDescription(
    @Json(name = "description")
    val description: String
) : ICategoryItemsData
