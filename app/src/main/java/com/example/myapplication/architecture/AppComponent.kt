package com.example.myapplication.architecture

import com.example.myapplication.partners.ApiModule
import com.example.myapplication.partners.PartnersFragment
import com.example.myapplication.partners.RepositoryModule
import com.example.myapplication.partners.UtilsModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [ApplicationModule::class, ViewModelModule::class, RepositoryModule::class, ApiModule::class, UtilsModule::class
    ]
)
interface AppComponent {
    fun inject(mainApplication: MainApplication)
    fun inject(partnersFragment: PartnersFragment)
}