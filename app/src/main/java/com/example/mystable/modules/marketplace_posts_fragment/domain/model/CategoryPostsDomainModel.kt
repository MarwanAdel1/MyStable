package com.example.mystable.modules.marketplace_posts_fragment.domain.model

data class CategoryPostsDomainModel(
    val categoryId: Int,
    val categoryPosts: List<PostDetailsDomainModel>
)
