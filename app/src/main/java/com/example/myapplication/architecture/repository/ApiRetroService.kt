package com.example.myapplication.architecture.repository

import com.example.myapplication.partners.domain.model.PartnerNetworkModel
import io.reactivex.Completable
import io.reactivex.Single
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiRetroService {
    @GET("service-providers")
    fun getProviders(): Single<List<PartnerNetworkModel>>

    @POST("service-providers")
    fun addProvider(@Body body: RequestBody): Completable
}