package com.example.mystable.modules.marketplace_post_details_fragment.data.model

import com.squareup.moshi.Json

data class ItemImages(
    @Json(name = "imageUrl")
    val imageUrl: List<String>
) : ICategoryItemsData