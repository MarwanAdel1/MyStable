package com.example.mystable.data.model

data class ItemDetails(
    val categoryId: Int,
    val itemId: Int,
    val itemData: List<ICategoryItemsData>
)
