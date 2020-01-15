package com.example.myapplication.partners

import com.example.myapplication.architecture.AdapterModel

data class PartnerViewModel(
    override val id: String? = "99",
    val name: String? = "default name",
    val description: String? = "default description",
    val imageUrl: String? = "https://upload.wikimedia.org/wikipedia/commons/3/3d/Iceberg_in_the_Arctic_with_its_underside_exposed.jpg"
): AdapterModel