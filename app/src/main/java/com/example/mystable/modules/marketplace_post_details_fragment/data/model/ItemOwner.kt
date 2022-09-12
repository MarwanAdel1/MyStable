package com.example.mystable.modules.marketplace_post_details_fragment.data.model

import com.squareup.moshi.Json

data class ItemOwner(
    @Json(name = "soldStatus")
    val soldStatus: Boolean,
    @Json(name = "owner")
    val owner: ItemOwnerInfo
) : ICategoryItemsData
