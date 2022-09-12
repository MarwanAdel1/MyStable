package com.example.mystable.modules.marketplace_post_details_fragment.domain.model

data class PostDetailsDomainModel(
    val categoryId: Int,
    val postId: Int,
    val postDetails: List<ICategoryPostDetailsDomain>
)