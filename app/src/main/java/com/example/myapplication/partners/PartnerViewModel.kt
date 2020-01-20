package com.example.myapplication.partners

import com.example.myapplication.architecture.adapter.AdapterModel

data class PartnerViewModel(
    override val id: String? = "99",
    val name: String? = "placeholder name",
    val description: String? = "why does my backend serves empty objects?",
    val imageUrl: String? = "https://media.licdn.com/dms/image/C4D0BAQGK8oL5fRh-DA/company-logo_200_200/0?e=2159024400&v=beta&t=ndHMD_8h-LMhKXfml-_t-bcjNJTTrjJWAjKJotzdDyU"
): AdapterModel