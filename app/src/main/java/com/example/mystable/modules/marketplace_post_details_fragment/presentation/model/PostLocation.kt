package com.example.mystable.modules.marketplace_post_details_fragment.presentation.model

import com.google.android.gms.maps.model.LatLng

data class PostLocation(
    val locationDescription: String,
    val location: LatLng
) : ICategoryPostDetailsUi
