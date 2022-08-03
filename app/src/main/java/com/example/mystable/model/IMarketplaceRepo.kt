package com.example.mystable.model

import com.example.mystable.pojo.Category
import com.example.mystable.pojo.CategoryDetails
import com.example.mystable.pojo.ItemDetails

interface IMarketplaceRepo {
    suspend fun getCategories(flag: Boolean): List<Category>
    suspend fun getCategoryDetails(id: Int): CategoryDetails?

    suspend fun getItemDetails(categoryId: Int, itemId: Int): ItemDetails?
}