package com.example.mystable.modules.marketplace_post_details_fragment.domain.model

data class PostInfoDomain(
    val infoStatus: Boolean,
    val info: Map<String, Any>?
) : ICategoryPostDetailsDomain
