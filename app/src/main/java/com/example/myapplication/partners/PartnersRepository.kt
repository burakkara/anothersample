package com.example.myapplication.partners

import io.reactivex.Single

interface PartnersRepository {
    fun getPartners(): Single<List<PartnerNetworkModel>>
}