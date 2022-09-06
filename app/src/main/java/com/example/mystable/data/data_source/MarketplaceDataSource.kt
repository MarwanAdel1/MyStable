package com.example.mystable.data.data_source

import com.example.mystable.data.model.Category
import com.example.mystable.data.model.CategoryDetails
import com.example.mystable.data.model.ItemDetails
import com.example.mystable.data.model.ItemSimilarItem

interface MarketplaceDataSource {
    suspend fun getCatInfo(flag: Boolean): List<Category>

    suspend fun getCatItems(id: Int): CategoryDetails?

    suspend fun getItemData(categoryId: Int, itemId: Int): ItemDetails?

    suspend fun getSimilarItems(categoryId: Int): ItemSimilarItem?
}
