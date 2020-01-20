package com.example.myapplication.partners.repository

import com.example.myapplication.partners.domain.model.PartnerNetworkModel
import io.reactivex.Single

interface Api {
    fun getPartners() : Single<List<PartnerNetworkModel>>
}