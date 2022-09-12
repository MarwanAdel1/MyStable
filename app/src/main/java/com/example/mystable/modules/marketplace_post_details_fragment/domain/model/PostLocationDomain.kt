package com.example.mystable.modules.marketplace_post_details_fragment.domain.model

import com.google.android.gms.maps.model.LatLng

data class PostLocationDomain(
    val locationDescription: String,
    val location: LatLng
) : ICategoryPostDetailsDomain
