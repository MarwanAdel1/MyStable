package com.example.mystable.modules.marketplace_post_details_fragment.domain.model

data class PostSimilarItemsDomain(
    val categoryId: Int,
    val posts: List<PostSimilarItemsInfoDomain>
) : ICategoryPostDetailsDomain
