package com.example.myapplication.partners.repository

import com.example.myapplication.addpartner.domain.model.AddPartnerRequest
import com.example.myapplication.architecture.repository.ApiRetroService
import com.example.myapplication.architecture.repository.HeadersInterceptor
import com.example.myapplication.architecture.repository.UrlProvider
import com.example.myapplication.partners.domain.model.PartnerNetworkModel
import com.example.myapplication.util.GsonProvider
import io.reactivex.Completable
import io.reactivex.Single
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiImpl @Inject constructor(
    private val urlProvider: UrlProvider,
    private val headersInterceptor: HeadersInterceptor,
    private val gsonProvider: GsonProvider
) :
    Api {
    private val service: ApiRetroService = Retrofit.Builder()
        .baseUrl(urlProvider.baseUrl)
        .client(OkHttpClient.Builder().addInterceptor(headersInterceptor).build())
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(ApiRetroService::class.java)

    override fun getPartners(): Single<List<PartnerNetworkModel>> = service.getProviders()

    override fun addPartner(request: AddPartnerRequest): Completable =
        service.addProvider(gsonProvider.gson.toJson(request).toRequestBody(MEDIA_TYPE))

    private companion object {
        private val MEDIA_TYPE = "application/json".toMediaTypeOrNull()
    }
}