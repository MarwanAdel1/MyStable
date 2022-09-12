package com.example.mystable.modules.marketplace_posts_fragment.presentation.mapper

import com.example.mystable.modules.marketplace_posts_fragment.domain.model.CategoryPostsDomainModel
import com.example.mystable.modules.marketplace_posts_fragment.presentation.model.CategoryPostsUiModel
import com.example.mystable.modules.marketplace_posts_fragment.presentation.model.PostDetailsUi

object PostsUiMapper {
    fun postsToPostsUIModel(categoryPosts: CategoryPostsDomainModel?): CategoryPostsUiModel {
        val posts = mutableListOf<PostDetailsUi>()

        categoryPosts?.categoryPosts?.forEach {
            val post = PostDetailsUi(
                id = it.id,
                name = it.name,
                imageUrl = it.imageUrl,
                currencySymbol = it.currencySymbol,
                price = it.price
            )

            posts.add(post)
        }

        return CategoryPostsUiModel(
            categoryId = categoryPosts?.categoryId ?: -1,
            categoryPosts = posts
        )
    }
}