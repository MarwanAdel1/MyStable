package com.example.mystable.pojo

data class ItemSimilarItem(
    val categoryId: Int,
    val items: List<CategoryItemData>
) : ICategoryItemsData
