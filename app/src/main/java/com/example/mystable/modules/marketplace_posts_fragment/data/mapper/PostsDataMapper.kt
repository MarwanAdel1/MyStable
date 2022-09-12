package com.example.mystable.modules.marketplace_posts_fragment.data.mapper

import com.example.mystable.modules.marketplace_posts_fragment.data.model.CategoryDetails
import com.example.mystable.modules.marketplace_posts_fragment.domain.model.CategoryPostsDomainModel
import com.example.mystable.modules.marketplace_posts_fragment.domain.model.PostDetailsDomainModel

object PostsDataMapper {
    fun postsToPostsDomainModel(categoryPosts: CategoryDetails): CategoryPostsDomainModel {
        val posts = mutableListOf<PostDetailsDomainModel>()

        categoryPosts.categoryItemData.forEach {
            val post = PostDetailsDomainModel(
                id = it.id,
                name = it.name,
                imageUrl = it.imageUrl,
                currencySymbol = it.currencySymbol,
                price = it.price
            )

            posts.add(post)
        }

        return CategoryPostsDomainModel(
            categoryId = categoryPosts.categoryId,
            categoryPosts = posts
        )
    }
}