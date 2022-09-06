package com.example.mystable.data.model

import com.google.android.gms.maps.model.LatLng

data class ItemLocation(
    val locationDescription: String,
    val location: LatLng
) : ICategoryItemsData
