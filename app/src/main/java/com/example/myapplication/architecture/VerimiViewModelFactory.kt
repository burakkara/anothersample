package com.example.myapplication.architecture

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class VerimiViewModelFactory @Inject constructor(
    private val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        var creator = creators[modelClass]

        if (creator == null) {
            creator = creators.entries.find { modelClass.isAssignableFrom(it.key) }?.value
        }

        if (creator == null) {
            throw IllegalArgumentException("Unknown model class $modelClass")
        }

        return creator.get() as T
    }
}