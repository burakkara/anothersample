package com.example.myapplication.architecture.di

import com.example.myapplication.addpartner.AddPartnerFragment
import com.example.myapplication.architecture.MainApplication
import com.example.myapplication.architecture.viewmodel.ViewModelModule
import com.example.myapplication.partners.PartnersFragment
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
    fun inject(addPartnerFragment: AddPartnerFragment)
}