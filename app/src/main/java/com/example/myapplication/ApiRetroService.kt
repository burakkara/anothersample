package com.example.myapplication

import com.example.myapplication.partners.PartnerNetworkModel
import io.reactivex.Single
import retrofit2.http.GET

interface ApiRetroService {
    @GET("service-providers")
    fun getProviders(): Single<List<PartnerNetworkModel>>
}