package com.example.myapplication.addpartner

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.State
import com.example.myapplication.addpartner.domain.AddPartnerUseCase
import com.example.myapplication.addpartner.domain.model.AddPartnerNetworkModel
import com.example.myapplication.architecture.BaseViewModel
import com.example.myapplication.util.SchedulersProvider
import com.example.myapplication.util.plusAssign
import javax.inject.Inject

class AddPartnerViewModel @Inject constructor(
    private val addPartnerUseCase: AddPartnerUseCase,
    private val schedulersProvider: SchedulersProvider
) :
    BaseViewModel() {
    val state: LiveData<State>
        get() = stateLiveData

    private val stateLiveData = MutableLiveData<State>()

    fun submit(
        name: String,
        description: String
    ) {
        disposables += addPartnerUseCase.run(AddPartnerNetworkModel(name = name, description = description))
            .subscribeOn(schedulersProvider.io())
            .observeOn(schedulersProvider.ui())
            .subscribe(
                this::onSuccess,
                this::onError
            )
    }

    private fun onSuccess() {
        stateLiveData.value = State.SUCCESS
    }

    private fun onError(error: Throwable) {
        stateLiveData.value = State.FAILURE
    }
}