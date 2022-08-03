package com.example.mystable.pojo

data class ItemOwner(
    val soldStatus: Boolean,
    val owner: ItemOwnerInfo?
) : ICategoryItemsData
