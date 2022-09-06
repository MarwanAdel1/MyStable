package com.example.mystable.data.model

data class ItemSimilarItem(
    val categoryId: Int,
    val items: List<CategoryItemData>
) : ICategoryItemsData
