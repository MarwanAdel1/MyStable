package com.example.mystable.modules.marketplace_post_details_fragment.data.model

import com.example.mystable.modules.marketplace_category_fragment.data.model.CategoryItemData

data class ItemSimilarItem(
    val categoryId: Int,
    val items: List<CategoryItemData>
) : ICategoryItemsData
