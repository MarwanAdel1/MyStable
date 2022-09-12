package com.example.mystable.modules.marketplace_posts_fragment.presentation.mapper

import com.example.mystable.modules.marketplace_posts_fragment.domain.model.CategoryDomainModel
import com.example.mystable.modules.marketplace_posts_fragment.presentation.model.CategoryUiModel

object CategoryUiMapper {
    fun categoryToUiModel(categoriesList: List<CategoryDomainModel>): List<CategoryUiModel> {
        val categories = mutableListOf<CategoryUiModel>()

        categoriesList.forEach {
            val category = CategoryUiModel(id = it.id, name = it.name)
            categories.add(category)
        }

        return categories
    }
}