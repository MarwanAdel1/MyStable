package com.example.mystable.modules.marketplace_post_details_fragment.presentation.model

data class PostInfo(
    val infoStatus: Boolean,
    val info: Map<String, Any>?
) : ICategoryPostDetailsUi
