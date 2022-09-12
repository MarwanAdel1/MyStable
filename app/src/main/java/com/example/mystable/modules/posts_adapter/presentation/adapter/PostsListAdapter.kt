package com.example.mystable.modules.posts_adapter.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mystable.R
import com.example.mystable.databinding.ItemCategoryItemsBinding
import com.example.mystable.modules.posts_adapter.presentation.model.PostModel
import com.example.mystable.modules.posts_adapter.presentation.view.PostsClickCallback
import javax.inject.Inject

class PostsListAdapter @Inject constructor(
    private val myContext: Context,
    private val communicator: PostsClickCallback
) : RecyclerView.Adapter<PostsListAdapter.PostsListViewHolder>() {

    private lateinit var posts: PostModel

    fun setTabDetails(categoryPosts: PostModel) {
        this.posts = categoryPosts
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PostsListViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view = ItemCategoryItemsBinding.inflate(layoutInflater, parent, false)

        return PostsListViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostsListViewHolder, position: Int) {
        holder.binding.apply {
            itemName.text = posts.posts[position].name
            itemPrice.text =
                "${posts.posts[position].currencySymbol} ${posts.posts[position].price}"
            Glide.with(myContext)
                .load(posts.posts[position].imageUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .centerCrop()
                .into(itemImage)

            itemImage.clipToOutline = true

            itemView.setOnClickListener {
                communicator.getPostDetails(
                    posts.categoryId,
                    posts.posts[position].id,
                    it
                )
            }
        }
    }

    override fun getItemCount(): Int {
        var size = 0
        if (::posts.isInitialized) {
            size = posts.posts.size
        }
        return size
    }

    inner class PostsListViewHolder(val binding: ItemCategoryItemsBinding) :
        RecyclerView.ViewHolder(binding.root)

}