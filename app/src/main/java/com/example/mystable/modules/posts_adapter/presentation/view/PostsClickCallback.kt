package com.example.mystable.modules.posts_adapter.presentation.view

import android.view.View

interface PostsClickCallback {
    fun getPostDetails(categoryId: Int, itemId: Int, view: View)
}
