package com.example.mystable.modules.posts_adapter.presentation.model

data class PostInfoAdapter constructor(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val currencySymbol: String,
    val price: Double
)
