package com.example.mystable.pojo

data class ItemInfo(
    val infoStatus: Boolean,
    val info: Map<String, Any>?
) : ICategoryItemsData
