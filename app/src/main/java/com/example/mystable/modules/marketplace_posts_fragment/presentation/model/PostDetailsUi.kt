package com.example.mystable.modules.marketplace_posts_fragment.presentation.model

data class PostDetailsUi(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val currencySymbol: String,
    val price: Double
)
