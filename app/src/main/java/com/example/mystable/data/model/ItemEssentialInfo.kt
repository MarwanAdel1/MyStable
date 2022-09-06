package com.example.mystable.data.model

import java.util.*

data class ItemEssentialInfo(
    val id: Int,
    val name: String,
    val price: Double,
    val endDate: Date,
    val currencySymbol: String
) : ICategoryItemsData
