package com.example.mystable.pojo

import com.google.android.gms.maps.model.LatLng

data class ItemLocation(
    val locationDescription: String,
    val location: LatLng
): ICategoryItemsData
