package com.example.mystable.modules.marketplace_post_details_fragment.domain.model

data class PostOwnerDomain(
    val soldStatus: Boolean,
    val owner: PostOwnerInfoDomain
) : ICategoryPostDetailsDomain
