package com.example.mystable.marketplace_post_details_fragment.data.model

import com.example.mystable.marketplace_post_details_fragment.data.model.ICategoryItemsData

data class ItemInfo(
    val infoStatus: Boolean,
    val info: Map<String, Any>?
) : ICategoryItemsData
