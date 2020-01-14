package com.example.myapplication.partners

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.architecture.Resource
import com.example.myapplication.utils.SchedulersProvider
import javax.inject.Inject

class PartnersViewModel @Inject constructor(
    private val getPartnersUseCase: GetPartnersUseCase,
    private val schedulersProvider: SchedulersProvider
) :
    ViewModel() {

    val state: LiveData<Resource<List<PartnerViewModel>>>
        get() = stateLiveData

    private val stateLiveData = MutableLiveData<Resource<List<PartnerViewModel>>>()

    init {
        stateLiveData.value = Resource.LoadingResource()
    }

    fun updatePartnersList() {
        getPartnersUseCase.run()
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
        ) // todo databind for errors?
    }
}