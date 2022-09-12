package com.example.mystable.modules.marketplace_post_details_fragment.data.mapper

import com.example.mystable.modules.marketplace_post_details_fragment.data.model.*
import com.example.mystable.modules.marketplace_post_details_fragment.domain.model.*

object PostDetailsMapper {
    fun toPostDetailsDomainModel(postData: ItemDetails?): PostDetailsDomainModel {
        val post = mutableListOf<ICategoryPostDetailsDomain>()

        if (postData != null) {
            for (index in 0 until postData.itemData.size) {
                when (postData.itemData[index]) {
                    is ItemEssentialInfo -> {
                        val postEssentialInfoDomain = PostEssentialInfoDomain(
                            id = (postData.itemData[index] as ItemEssentialInfo).id,
                            name = (postData.itemData[index] as ItemEssentialInfo).name,
                            price = (postData.itemData[index] as ItemEssentialInfo).price,
                            endDate = (postData.itemData[index] as ItemEssentialInfo).endDate,
                            currencySymbol = (postData.itemData[index] as ItemEssentialInfo).currencySymbol
                        )
                        post.add(postEssentialInfoDomain)
                    }
                    is ItemImages -> {
                        val postImagesDomain = PostImagesDomain(
                            imageUrl = (postData.itemData[index] as ItemImages).imageUrl
                        )
                        post.add(postImagesDomain)
                    }
                    is ItemDescription -> {
                        val postDescriptionDomain = PostDescriptionDomain(
                            description = (postData.itemData[index] as ItemDescription).description
                        )
                        post.add(postDescriptionDomain)
                    }
                    is ItemOwner -> {
                        val postOwnerInfoDomain = PostOwnerInfoDomain(
                            ownerImage = (postData.itemData[index] as ItemOwner).owner.ownerImage,
                            ownerName = (postData.itemData[index] as ItemOwner).owner.ownerName,
                            ownerDesc = (postData.itemData[index] as ItemOwner).owner.ownerDesc,
                            ownerEmail = (postData.itemData[index] as ItemOwner).owner.ownerEmail,
                            ownerPhone = (postData.itemData[index] as ItemOwner).owner.ownerPhone,
                            ownerChatAvailability = (postData.itemData[index] as ItemOwner).owner.ownerChatAvailability,
                            ownerChat = (postData.itemData[index] as ItemOwner).owner.ownerChat
                        )

                        val postOwnerDomain = PostOwnerDomain(
                            soldStatus = (postData.itemData[index] as ItemOwner).soldStatus,
                            owner = postOwnerInfoDomain
                        )
                        post.add(postOwnerDomain)
                    }
                    is ItemLocation -> {
                        val postLocationDomain = PostLocationDomain(
                            location = (postData.itemData[index] as ItemLocation).location,
                            locationDescription = (postData.itemData[index] as ItemLocation).locationDescription
                        )
                        post.add(postLocationDomain)
                    }
                    is ItemInfo -> {
                        val postInfoDomain = PostInfoDomain(
                            infoStatus = (postData.itemData[index] as ItemInfo).infoStatus,
                            info = (postData.itemData[index] as ItemInfo).info
                        )
                        post.add(postInfoDomain)
                    }
                    is ItemSimilarItem -> {
                        val postSimilarItems =
                            toPostSimilarItemDomainModel(postData.itemData[index] as ItemSimilarItem)

                        post.add(postSimilarItems)
                    }
                }
            }
        }

        return PostDetailsDomainModel(
            categoryId = postData?.categoryId ?: -1,
            postId = postData?.itemId ?: -1,
            postDetails = post
        )
    }

    fun toPostSimilarItemDomainModel(similarPosts: ItemSimilarItem?): PostSimilarItemsDomain {
        val postSimilarItemInfoList = mutableListOf<PostSimilarItemsInfoDomain>()

        similarPosts?.items?.forEach {
            val postSimilarItemInfo = PostSimilarItemsInfoDomain(
                id = it.id,
                name = it.name,
                price = it.price,
                imageUrl = it.imageUrl,
                currencySymbol = it.currencySymbol
            )

            postSimilarItemInfoList.add(postSimilarItemInfo)
        }

        return PostSimilarItemsDomain(
            categoryId = similarPosts?.categoryId ?: -1,
            posts = postSimilarItemInfoList
        )
    }
}