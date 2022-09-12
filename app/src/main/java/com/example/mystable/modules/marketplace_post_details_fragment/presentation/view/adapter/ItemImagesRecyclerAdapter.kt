package com.example.mystable.modules.marketplace_post_details_fragment.presentation.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mystable.R
import com.example.mystable.databinding.ItemCategoryItemImagesItemBinding
import com.example.mystable.modules.marketplace_post_details_fragment.presentation.model.PostImages

class ItemImagesRecyclerAdapter(
    private val myContext: Context,
    private var images: PostImages
) : RecyclerView.Adapter<ItemImagesRecyclerAdapter.ItemImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemImageViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view = ItemCategoryItemImagesItemBinding.inflate(layoutInflater, parent, false)

        return ItemImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemImageViewHolder, position: Int) {
        holder.apply {
            val layoutParam: RecyclerView.LayoutParams =
                binding.itemImagesConstraint.layoutParams as RecyclerView.LayoutParams
            if (images.imageUrl.size > 1) {
                layoutParam.width = (myContext.resources.displayMetrics.density * 280).toInt()
                layoutParam.height = (myContext.resources.displayMetrics.density * 186).toInt()
            } else {
                layoutParam.width = ConstraintLayout.LayoutParams.MATCH_PARENT
                layoutParam.height =
                    (myContext.resources.displayMetrics.density * 186).toInt()
            }

            binding.itemImagesView.clipToOutline = true

            Glide.with(myContext)
                .load(images.imageUrl[position])
                .placeholder(R.drawable.ic_launcher_background)
                .centerCrop()
                .into(binding.itemImagesView)
        }
    }

    override fun getItemCount(): Int {
        return images.imageUrl.size
    }


    inner class ItemImageViewHolder(val binding: ItemCategoryItemImagesItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}