package com.example.mystable.modules.marketplace_post_details_fragment.presentation.model

data class PostSimilarItemsUi(
    val categoryId: Int,
    val posts: List<PostSimilarItemsInfo>
) : ICategoryPostDetailsUi
