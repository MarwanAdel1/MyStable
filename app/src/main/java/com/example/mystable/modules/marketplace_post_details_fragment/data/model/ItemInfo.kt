package com.example.mystable.modules.marketplace_post_details_fragment.data.model

import com.squareup.moshi.Json

data class ItemInfo(
    @Json(name = "infoStatus")
    val infoStatus: Boolean,
    @Json(name = "info")
    val info: Map<String, Any>?
) : ICategoryItemsData
