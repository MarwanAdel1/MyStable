package com.example.mystable.marketplace_post_details_fragment.data.model

import com.example.mystable.marketplace_post_details_fragment.data.model.ICategoryItemsData
import java.util.*

data class ItemEssentialInfo(
    val id: Int,
    val name: String,
    val price: Double,
    val endDate: Date,
    val currencySymbol: String
) : ICategoryItemsData
