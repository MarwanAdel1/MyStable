package com.example.mystable.modules.marketplace_posts_fragment.domain.model

data class PostDetailsDomainModel(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val currencySymbol: String,
    val price: Double
)
