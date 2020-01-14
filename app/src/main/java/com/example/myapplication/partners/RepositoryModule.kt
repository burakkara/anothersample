package com.example.myapplication.partners

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