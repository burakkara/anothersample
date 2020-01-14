package com.example.myapplication.partners

import com.example.myapplication.ApiRetroService
import com.example.myapplication.UrlProvider
import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiImpl @Inject constructor(private val urlProvider: UrlProvider) : Api {
    private val service: ApiRetroService = Retrofit.Builder()
        .baseUrl(urlProvider.baseUrl)
        .client(OkHttpClient.Builder().build())
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(ApiRetroService::class.java)

    override fun getPartners(): Single<List<PartnerNetworkModel>> = service.getProviders()
}