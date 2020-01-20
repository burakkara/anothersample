package com.example.myapplication.architecture.di

import com.example.myapplication.partners.repository.PartnersRepository
import com.example.myapplication.partners.repository.PartnersRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun providesPartnersRepository(partnersRepository: PartnersRepositoryImpl): PartnersRepository {
        return partnersRepository
    }
}