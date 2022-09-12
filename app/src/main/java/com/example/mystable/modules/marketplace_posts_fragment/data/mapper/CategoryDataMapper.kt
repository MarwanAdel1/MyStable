package com.example.mystable.modules.marketplace_posts_fragment.data.mapper

import com.example.mystable.modules.marketplace_posts_fragment.data.model.Category
import com.example.mystable.modules.marketplace_posts_fragment.domain.model.CategoryDomainModel

object CategoryDataMapper {
    fun categoryToDomainModel(categoryList: List<Category>): List<CategoryDomainModel> {
        val categories = mutableListOf<CategoryDomainModel>()

        categoryList.forEach {
            val category = CategoryDomainModel(
                id = it.id,
                name = it.name
            )

            categories.add(category)
        }

        return categories
    }
}