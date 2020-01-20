package com.example.myapplication.partners.repository

import com.example.myapplication.partners.domain.model.PartnerNetworkModel
import io.reactivex.Single

interface PartnersRepository {
    fun getPartners(): Single<List<PartnerNetworkModel>>
}