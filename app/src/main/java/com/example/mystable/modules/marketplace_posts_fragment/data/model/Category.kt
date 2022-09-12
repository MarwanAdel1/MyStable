package com.example.mystable.modules.marketplace_posts_fragment.data.model

import com.squareup.moshi.Json

data class Category(
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String
)
