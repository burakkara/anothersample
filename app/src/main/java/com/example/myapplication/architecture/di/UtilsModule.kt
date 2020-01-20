package com.example.myapplication.architecture.di

import com.example.myapplication.architecture.repository.UrlProvider
import com.example.myapplication.architecture.repository.UrlProviderImpl
import com.example.myapplication.util.GsonProvider
import com.example.myapplication.util.GsonProviderImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UtilsModule {
    @Provides
    @Singleton
    fun providesUrlProvider(impl: UrlProviderImpl): UrlProvider {
        return impl
    }

    @Provides
    @Singleton
    fun providesGsonProvider(impl: GsonProviderImpl): GsonProvider {
        return impl
    }
}