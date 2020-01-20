package com.example.myapplication.partners

import com.example.myapplication.architecture.repository.UrlProvider
import com.example.myapplication.architecture.repository.UrlProviderImpl
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