package com.example.mystable.pojo

import java.util.*

data class ItemInfoDetails(
    val name: String,
    val color: String,
    val sexType: String,
    val gender: String,
    val dob: Date,
    val breed: String,
    val strain: String
) : ICategoryItemsData
