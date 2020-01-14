package com.example.myapplication.partners

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