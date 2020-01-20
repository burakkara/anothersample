package com.example.myapplication.architecture.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.architecture.viewmodel.VerimiViewModelFactory
import com.example.myapplication.architecture.viewmodel.ViewModelKey
import com.example.myapplication.partners.PartnersViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Suppress("unused")
@Module
abstract class ViewModelModule {

    @Binds
    @Singleton
    abstract fun bindViewModelFactory(factory: VerimiViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(PartnersViewModel::class)
    abstract fun bindsPartnersViewModel(viewModel: PartnersViewModel): ViewModel
}