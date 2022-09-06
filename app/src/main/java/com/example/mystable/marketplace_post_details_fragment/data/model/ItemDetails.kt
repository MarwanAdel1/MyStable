package com.example.mystable.marketplace_post_details_fragment.data.model

import com.example.mystable.marketplace_post_details_fragment.data.model.ICategoryItemsData

data class ItemDetails(
    val categoryId: Int,
    val itemId: Int,
    val itemData: List<ICategoryItemsData>
)
