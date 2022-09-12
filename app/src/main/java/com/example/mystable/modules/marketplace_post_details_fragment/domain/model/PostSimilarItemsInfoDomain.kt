package com.example.mystable.modules.marketplace_post_details_fragment.domain.model

data class PostSimilarItemsInfoDomain(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val currencySymbol: String,
    val price: Double
)
