package com.example.mystable.modules.marketplace_post_details_fragment.data.model

import com.google.android.gms.maps.model.LatLng
import com.squareup.moshi.Json

data class ItemLocation(
    @Json(name = "locationDescription")
    val locationDescription: String,
    @Json(name = "location")
    val location: LatLng
) : ICategoryItemsData
