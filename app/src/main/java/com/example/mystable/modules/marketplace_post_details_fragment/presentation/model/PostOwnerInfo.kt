package com.example.mystable.modules.marketplace_post_details_fragment.presentation.model

data class PostOwnerInfo(
    val ownerImage: String,
    val ownerName: String,
    val ownerDesc: String,
    val ownerEmail: String,
    val ownerPhone: String,
    val ownerChatAvailability: Boolean,
    val ownerChat: String
)
