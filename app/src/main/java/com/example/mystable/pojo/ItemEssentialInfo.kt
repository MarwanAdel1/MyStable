package com.example.mystable.pojo

import java.util.*

data class ItemEssentialInfo(
    val id: Int,
    val name: String,
    val price: Double,
    val endDate: Date,
    val currencySymbol: String
) : ICategoryItemsData
