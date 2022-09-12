package com.example.mystable.modules.marketplace_post_details_fragment.data.model

import com.example.mystable.modules.marketplace_posts_fragment.data.model.CategoryItemData
import com.squareup.moshi.Json

data class ItemSimilarItem(
    @Json(name = "categoryId")
    val categoryId: Int,
    @Json(name = "items")
    val items: List<CategoryItemData>
) : ICategoryItemsData
