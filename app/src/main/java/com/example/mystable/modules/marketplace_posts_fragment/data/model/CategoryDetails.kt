package com.example.mystable.modules.marketplace_posts_fragment.data.model

import com.squareup.moshi.Json

data class CategoryDetails(
    @Json(name = "categoryId")
    val categoryId: Int,
    @Json(name = "categoryItemData")
    val categoryItemData: List<CategoryItemData>
)
