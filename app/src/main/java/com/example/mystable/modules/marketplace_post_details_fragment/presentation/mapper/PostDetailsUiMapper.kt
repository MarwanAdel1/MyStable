package com.example.mystable.modules.marketplace_post_details_fragment.presentation.mapper

import com.example.mystable.modules.marketplace_post_details_fragment.domain.model.*
import com.example.mystable.modules.marketplace_post_details_fragment.presentation.model.*

object PostDetailsUiMapper {
    fun toPostDetailsUiModel(postData: PostDetailsDomainModel?): PostDetailsUiModel {
        val post = mutableListOf<ICategoryPostDetailsUi>()

        if (postData != null) {
            for (index in 0 until postData.postDetails.size) {
                when (postData.postDetails[index]) {
                    is PostEssentialInfoDomain -> {
                        val postEssentialInfo = PostEssentialInfo(
                            id = (postData.postDetails[index] as PostEssentialInfoDomain).id,
                            name = (postData.postDetails[index] as PostEssentialInfoDomain).name,
                            price = (postData.postDetails[index] as PostEssentialInfoDomain).price,
                            endDate = (postData.postDetails[index] as PostEssentialInfoDomain).endDate,
                            currencySymbol = (postData.postDetails[index] as PostEssentialInfoDomain).currencySymbol
                        )
                        post.add(postEssentialInfo)
                    }
                    is PostImagesDomain -> {
                        val postImages = PostImages(
                            imageUrl = (postData.postDetails[index] as PostImagesDomain).imageUrl
                        )
                        post.add(postImages)
                    }
                    is PostDescriptionDomain -> {
                        val postDescription = PostDescription(
                            description = (postData.postDetails[index] as PostDescriptionDomain).description
                        )
                        post.add(postDescription)
                    }
                    is PostOwnerDomain -> {
                        val postOwnerInfo = PostOwnerInfo(
                            ownerImage = (postData.postDetails[index] as PostOwnerDomain).owner.ownerImage,
                            ownerName = (postData.postDetails[index] as PostOwnerDomain).owner.ownerName,
                            ownerDesc = (postData.postDetails[index] as PostOwnerDomain).owner.ownerDesc,
                            ownerEmail = (postData.postDetails[index] as PostOwnerDomain).owner.ownerEmail,
                            ownerPhone = (postData.postDetails[index] as PostOwnerDomain).owner.ownerPhone,
                            ownerChatAvailability = (postData.postDetails[index] as PostOwnerDomain).owner.ownerChatAvailability,
                            ownerChat = (postData.postDetails[index] as PostOwnerDomain).owner.ownerChat
                        )

                        val postOwner = PostOwner(
                            soldStatus = (postData.postDetails[index] as PostOwnerDomain).soldStatus,
                            owner = postOwnerInfo
                        )
                        post.add(postOwner)
                    }
                    is PostLocationDomain -> {
                        val postLocation = PostLocation(
                            location = (postData.postDetails[index] as PostLocationDomain).location,
                            locationDescription = (postData.postDetails[index] as PostLocationDomain).locationDescription
                        )
                        post.add(postLocation)
                    }
                    is PostInfoDomain -> {
                        val postInfo = PostInfo(
                            infoStatus = (postData.postDetails[index] as PostInfoDomain).infoStatus,
                            info = (postData.postDetails[index] as PostInfoDomain).info
                        )
                        post.add(postInfo)
                    }
                    is PostSimilarItemsDomain -> {
                        val postSimilarItems =
                            toPostSimilarItemUiModel(postData.postDetails[index] as PostSimilarItemsDomain)
                        post.add(postSimilarItems)
                    }
                }
            }
        }

        return PostDetailsUiModel(
            categoryId = postData?.categoryId ?: -1,
            postId = postData?.postId ?: -1,
            postDetails = post
        )
    }

    fun toPostSimilarItemUiModel(similarPosts: PostSimilarItemsDomain?): PostSimilarItemsUi {
        val postSimilarItemInfoList = mutableListOf<PostSimilarItemsInfo>()

        similarPosts?.posts?.forEach {
            val postSimilarItemInfo = PostSimilarItemsInfo(
                id = it.id,
                name = it.name,
                price = it.price,
                imageUrl = it.imageUrl,
                currencySymbol = it.currencySymbol
            )

            postSimilarItemInfoList.add(postSimilarItemInfo)
        }

        return PostSimilarItemsUi(
            categoryId = similarPosts?.categoryId ?: -1,
            posts = postSimilarItemInfoList
        )
    }
}