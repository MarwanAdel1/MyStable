package com.example.mystable.modules.marketplace_post_details_fragment.presentation.model

import java.util.*

data class PostEssentialInfo(
    val id: Int,
    val name: String,
    val price: Double,
    val endDate: Date,
    val currencySymbol: String
) : ICategoryPostDetailsUi
