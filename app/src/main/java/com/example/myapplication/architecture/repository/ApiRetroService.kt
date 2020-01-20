package com.example.myapplication.architecture.repository

import com.example.myapplication.partners.domain.model.PartnerNetworkModel
import io.reactivex.Single
import retrofit2.http.GET

interface ApiRetroService {
    @GET("service-providers")
    fun getProviders(): Single<List<PartnerNetworkModel>>
}