package com.example.myapplication

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HeadersInterceptor @Inject constructor(): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(
            chain.request().newBuilder().addHeader(
                "Content-Type",
                "application/json"
            ).addHeader(
                "x-apikey",
                "460888f4c77f2cba6c7fbb5e6be5f6cdf0937"
            ).build()
        )
    }
}