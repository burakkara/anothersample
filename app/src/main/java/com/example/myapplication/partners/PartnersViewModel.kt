package com.example.myapplication.partners

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.architecture.BaseViewModel
import com.example.myapplication.architecture.Resource
import com.example.myapplication.partners.domain.usecase.GetPartnersUseCase
import com.example.myapplication.util.SchedulersProvider
import com.example.myapplication.util.plusAssign
import javax.inject.Inject

class PartnersViewModel @Inject constructor(
    private val getPartnersUseCase: GetPartnersUseCase,
    private val schedulersProvider: SchedulersProvider
) :
    BaseViewModel() {

    val state: LiveData<Resource<List<PartnerViewModel>>>
        get() = stateLiveData

    private val stateLiveData = MutableLiveData<Resource<List<PartnerViewModel>>>()

    init {
        stateLiveData.value = Resource.LoadingResource()
    }

    fun updatePartnersList() {
        disposables += getPartnersUseCase.run()
            .subscribeOn(schedulersProvider.io())
            .observeOn(schedulersProvider.ui())
            .subscribe(
                this::onPartnersReceived,
                this::onError
            )
    }

    private fun onPartnersReceived(partners: List<PartnerViewModel>) {
        stateLiveData.value = Resource.LoadedResource(partners)
    }

    private fun onError(error: Throwable) {
        stateLiveData.value = Resource.ErrorResource(
            "Error title",
            "Error message"
        )
    }
}