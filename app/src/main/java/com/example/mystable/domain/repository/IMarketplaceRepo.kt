package com.example.mystable.domain.repository

import com.example.mystable.data.model.Category
import com.example.mystable.data.model.CategoryDetails
import com.example.mystable.data.model.ItemDetails
import com.example.mystable.data.model.ItemSimilarItem

interface IMarketplaceRepo {
    suspend fun getCategories(flag: Boolean): List<Category>
    suspend fun getCategoryDetails(id: Int): CategoryDetails?

    suspend fun getItemDetails(categoryId: Int, itemId: Int): ItemDetails?
    suspend fun getSimilarItems(categoryId: Int): ItemSimilarItem?
}