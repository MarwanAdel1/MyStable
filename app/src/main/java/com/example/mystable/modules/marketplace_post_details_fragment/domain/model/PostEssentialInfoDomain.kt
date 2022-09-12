package com.example.mystable.modules.marketplace_post_details_fragment.domain.model

import java.util.*

data class PostEssentialInfoDomain(
    val id: Int,
    val name: String,
    val price: Double,
    val endDate: Date,
    val currencySymbol: String
) : ICategoryPostDetailsDomain
