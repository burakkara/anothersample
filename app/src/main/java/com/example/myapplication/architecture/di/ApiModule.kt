package com.example.myapplication.architecture.di

import com.example.myapplication.partners.repository.Api
import com.example.myapplication.partners.repository.ApiImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApiModule {
    @Provides
    @Singleton
    fun providesPartnersApi(api: ApiImpl): Api {
        return api
    }
}