package com.example.myapplication.architecture

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

abstract class BaseMvvmFragment<VM : ViewModel> : Fragment() {
    protected abstract val viewModelType: Class<VM>
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    protected lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        viewModel = ViewModelProviders.of(requireActivity(), viewModelFactory)[viewModelType]
        super.onCreate(savedInstanceState)
    }
}
