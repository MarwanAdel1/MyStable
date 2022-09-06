package com.example.mystable.data.model

data class ItemInfo(
    val infoStatus: Boolean,
    val info: Map<String, Any>?
) : ICategoryItemsData
