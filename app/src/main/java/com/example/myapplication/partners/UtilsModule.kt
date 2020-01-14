package com.example.myapplication.partners

import com.example.myapplication.UrlProvider
import com.example.myapplication.UrlProviderImpl
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
}