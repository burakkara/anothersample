package com.example.myapplication.partners

import io.reactivex.Single

interface Api {
    fun getPartners() : Single<List<PartnerNetworkModel>>
}