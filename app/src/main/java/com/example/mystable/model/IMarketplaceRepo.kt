package com.example.mystable.model

import com.example.mystable.pojo.Category
import com.example.mystable.pojo.CategoryDetails
import com.example.mystable.pojo.ItemDetails
import com.example.mystable.pojo.ItemSimilarItem

interface IMarketplaceRepo {
    suspend fun getCategories(flag: Boolean): List<Category>
    suspend fun getCategoryDetails(id: Int): CategoryDetails?

    suspend fun getItemDetails(categoryId: Int, itemId: Int): ItemDetails?
    suspend fun getSimilarItems(categoryId: Int): ItemSimilarItem?
}