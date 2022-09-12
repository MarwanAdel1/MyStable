package com.example.mystable.modules.marketplace_post_details_fragment.presentation.model

data class PostDetailsUiModel(
    val categoryId: Int,
    val postId: Int,
    val postDetails: List<ICategoryPostDetailsUi>
)