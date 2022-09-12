package com.example.mystable.modules.posts_adapter.presentation.model

data class PostModel constructor(
    val categoryId: Int,
    val posts: List<PostInfoAdapter>
)