package com.example.mystable.modules.marketplace_post_details_fragment.presentation.view.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mystable.R
import com.example.mystable.databinding.*
import com.example.mystable.modules.marketplace_post_details_fragment.presentation.model.*
import com.example.mystable.modules.posts_adapter.presentation.adapter.PostsListAdapter
import com.example.mystable.modules.posts_adapter.presentation.model.PostInfoAdapter
import com.example.mystable.modules.posts_adapter.presentation.model.PostModel
import com.example.mystable.modules.posts_adapter.presentation.view.PostsClickCallback
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.text.SimpleDateFormat
import java.util.*


class ViewsRecyclerAdapter constructor(
    private val myContext: Context,
    private val myActivity: FragmentActivity,
    private val similarItemsCallback: PostsClickCallback
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var itemTypes: MutableList<ICategoryPostDetailsUi>

    fun setViews(itemTypes: List<ICategoryPostDetailsUi>) {
        this.itemTypes = itemTypes.toMutableList()
        notifyDataSetChanged()
    }

    fun setSimilarItems(items: PostSimilarItemsUi) {
        this.itemTypes.add(items)
        notifyItemChanged(this.itemTypes.size - 1)
    }

    override fun getItemViewType(position: Int): Int {
        when (position) {
            0 -> {
                if (itemTypes.any { it is PostEssentialInfo }) {
                    return 0
                }
            }
            1 -> {
                if (itemTypes.any { it is PostImages }) {
                    return 1
                }
            }
            2 -> {
                if (itemTypes.any { it is PostDescription }) {
                    return 2
                }
            }
            3 -> {
                if (itemTypes.any { it is PostOwner }) {
                    return 3
                }
            }
            4 -> {
                if (itemTypes.any { it is PostLocation }) {
                    return 4
                }
            }
            5 -> {
                if (itemTypes.any { it is PostInfo }) {
                    return 5
                } else if (itemTypes.any { it is PostSimilarItemsUi }) {
                    return 6
                }
            }
            6 -> {
                if (itemTypes.any { it is PostSimilarItemsUi }) {
                    return 6
                }
            }
        }
        return -1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        when (viewType) {
            0 -> return ItemEssentialInfoViewHolder(
                ItemCategoryItemEssentialInfoBinding.inflate(
                    layoutInflater,
                    parent,
                    false
                )
            )
            1 -> return ItemImagesViewHolder(
                ItemCategoryItemImagesBinding.inflate(
                    layoutInflater,
                    parent,
                    false
                )
            )
            2 -> return ItemDescriptionViewHolder(
                ItemCategoryItemDescriptionBinding.inflate(
                    layoutInflater,
                    parent,
                    false
                )
            )
            3 -> return ItemOwnerViewHolder(
                ItemCategoryItemOwnerOrSoldBinding.inflate(
                    layoutInflater,
                    parent,
                    false
                )
            )
            4 -> return ItemMapViewHolder(
                ItemCategoryItemLocationDetailsBinding.inflate(
                    layoutInflater,
                    parent,
                    false
                )
            )
            5 -> return ItemInfoViewHolder(
                ItemCategoryItemInfoBinding.inflate(
                    layoutInflater,
                    parent,
                    false
                )
            )
            6 -> return SimilarItemsViewHolder(
                ItemCategoryItemSimilarItemsBinding.inflate(
                    layoutInflater,
                    parent,
                    false
                )
            )
            else -> throw IllegalArgumentException("Invalid View Type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ItemEssentialInfoViewHolder -> holder.bind(itemTypes.first { it is PostEssentialInfo } as PostEssentialInfo)
            is ItemImagesViewHolder -> holder.bind(itemTypes.first { it is PostImages } as PostImages)
            is ItemDescriptionViewHolder -> holder.bind(itemTypes.first { it is PostDescription } as PostDescription)
            is ItemOwnerViewHolder -> holder.bind(itemTypes.first { it is PostOwner } as PostOwner)
            is ItemMapViewHolder -> holder.bind(itemTypes.first { it is PostLocation } as PostLocation)
            is ItemInfoViewHolder -> holder.bind(itemTypes.first { it is PostInfo } as PostInfo)
            is SimilarItemsViewHolder -> holder.bind(itemTypes.first { it is PostSimilarItemsUi } as PostSimilarItemsUi)
        }
    }

    override fun getItemCount(): Int {
        var size = 0
        if (::itemTypes.isInitialized) {
            size = itemTypes.size
        }
        return size
    }

    inner class ItemEssentialInfoViewHolder(private val binding: ItemCategoryItemEssentialInfoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(info: PostEssentialInfo) {
            binding.itemName.text = info.name
            binding.itemPrice.text = "${info.currencySymbol} ${info.price}"
            binding.itemEndTime.text =
                "${myContext.getString(R.string.this_ad_ends)} ${convertDateToString(info.endDate)}"
        }

        private fun convertDateToString(date: Date): String {
            return SimpleDateFormat("d MMMM").format(date)
        }
    }

    inner class ItemImagesViewHolder(private val binding: ItemCategoryItemImagesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(images: PostImages) {
            val imagesAdapter = ItemImagesRecyclerAdapter(myContext, images)
            binding.imagesRecyclerview.adapter = imagesAdapter
        }
    }

    inner class ItemDescriptionViewHolder(private val binding: ItemCategoryItemDescriptionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(desc: PostDescription) {
            binding.descriptionTx.text = desc.description
        }
    }

    inner class ItemInfoViewHolder(private val binding: ItemCategoryItemInfoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(info: PostInfo) {
            val infoRecyclerAdapter = InfoRecyclerAdapter(info)
            binding.itemInfoRecyclerView.adapter = infoRecyclerAdapter
            if (info.infoStatus) {
                binding.root.visibility = View.VISIBLE
            } else {
                binding.root.visibility = View.GONE
            }
        }
    }

    inner class ItemMapViewHolder(private val binding: ItemCategoryItemLocationDetailsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(location: PostLocation) {
            binding.locationDescriptionTx.text = location.locationDescription

            initializeMap(location.location)
        }

        private fun initializeMap(itemLocation: LatLng) {
            val callback = OnMapReadyCallback { googleMap ->
                googleMap.addMarker(
                    MarkerOptions().position(itemLocation).title("Item Location")
                )
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(itemLocation))
            }

            val mapFragment = SupportMapFragment.newInstance()
            myActivity.supportFragmentManager
                .beginTransaction()
                .add(R.id.map, mapFragment)
                .commit()
            mapFragment.getMapAsync(callback)
        }
    }

    inner class ItemOwnerViewHolder(private val binding: ItemCategoryItemOwnerOrSoldBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(owner: PostOwner) {
            if (owner.soldStatus) { // sold out
                changeVisibility(owner.soldStatus)
            } else {
                changeVisibility(owner.soldStatus)

                Glide.with(myContext)
                    .load(owner.owner.ownerImage)
                    .placeholder(R.drawable.ic_launcher_background)
                    .centerCrop()
                    .into(binding.ownerImage)

                binding.ownerName.text = owner.owner.ownerName
                binding.ownerDescTx.text = owner.owner.ownerDesc
                binding.ownerChatBt.setOnClickListener {

                }
                binding.ownerMailBt.setOnClickListener {

                }
                binding.ownerPhoneBt.setOnClickListener {

                }
            }
        }

        private fun changeVisibility(soldFlag: Boolean) {
            if (soldFlag) { // sold out
                binding.soldBt.visibility = View.VISIBLE

                binding.ownerAndSoldView.visibility = View.GONE
                binding.ownerImage.visibility = View.GONE
                binding.ownerName.visibility = View.GONE
                binding.ownerDescTx.visibility = View.GONE
                binding.ownerChatBt.visibility = View.GONE
                binding.ownerMailBt.visibility = View.GONE
                binding.ownerPhoneBt.visibility = View.GONE
            } else {
                binding.soldBt.visibility = View.GONE

                binding.ownerAndSoldView.visibility = View.VISIBLE
                binding.ownerImage.visibility = View.VISIBLE
                binding.ownerName.visibility = View.VISIBLE
                binding.ownerDescTx.visibility = View.VISIBLE
                binding.ownerChatBt.visibility = View.VISIBLE
                binding.ownerMailBt.visibility = View.VISIBLE
                binding.ownerPhoneBt.visibility = View.VISIBLE
            }
        }
    }

    inner class SimilarItemsViewHolder(private val binding: ItemCategoryItemSimilarItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(similarItem: PostSimilarItemsUi) {
            val similarItemAdapter = PostsListAdapter(
                myContext,
                similarItemsCallback
            )
            binding.similarItemsRecyclerview.adapter = similarItemAdapter

            similarItemAdapter.setTabDetails(toPostModel(similarItem))
        }

        private fun toPostModel(similarPosts: PostSimilarItemsUi): PostModel {
            val posts = mutableListOf<PostInfoAdapter>()

            similarPosts.posts.forEach {
                val post = PostInfoAdapter(
                    id = it.id,
                    name = it.name,
                    imageUrl = it.imageUrl,
                    currencySymbol = it.currencySymbol,
                    price = it.price
                )

                posts.add(post)
            }

            return PostModel(
                categoryId = similarPosts.categoryId,
                posts = posts
            )
        }
    }
}
