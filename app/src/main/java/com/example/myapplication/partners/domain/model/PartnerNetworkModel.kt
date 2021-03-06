package com.example.myapplication.partners.domain.model

import com.google.gson.annotations.SerializedName

data class PartnerNetworkModel(
    @SerializedName("_id")
    val id: String?,
    @SerializedName("displayName")
    val name: String?,
    val description: String?,
    val imageUrl: String?
)