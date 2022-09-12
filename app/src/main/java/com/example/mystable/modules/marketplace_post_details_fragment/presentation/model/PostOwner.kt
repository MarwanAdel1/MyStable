package com.example.mystable.modules.marketplace_post_details_fragment.presentation.model

data class PostOwner(
    val soldStatus: Boolean,
    val owner: PostOwnerInfo
) : ICategoryPostDetailsUi
