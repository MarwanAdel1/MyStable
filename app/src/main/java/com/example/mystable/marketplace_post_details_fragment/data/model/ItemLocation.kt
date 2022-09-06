package com.example.mystable.marketplace_post_details_fragment.data.model

import com.example.mystable.marketplace_post_details_fragment.data.model.ICategoryItemsData
import com.google.android.gms.maps.model.LatLng

data class ItemLocation(
    val locationDescription: String,
    val location: LatLng
) : ICategoryItemsData
