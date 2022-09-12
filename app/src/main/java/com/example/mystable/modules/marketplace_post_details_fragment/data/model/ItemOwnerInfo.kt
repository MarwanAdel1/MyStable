package com.example.mystable.modules.marketplace_post_details_fragment.data.model

import com.squareup.moshi.Json

data class ItemOwnerInfo(
    @Json(name = "ownerImage")
    val ownerImage: String,
    @Json(name = "ownerName")
    val ownerName: String,
    @Json(name = "ownerDesc")
    val ownerDesc: String,
    @Json(name = "ownerEmail")
    val ownerEmail: String,
    @Json(name = "ownerPhone")
    val ownerPhone: String,
    @Json(name = "ownerChatAvailability")
    val ownerChatAvailability: Boolean,
    @Json(name = "ownerChat")
    val ownerChat: String
)
