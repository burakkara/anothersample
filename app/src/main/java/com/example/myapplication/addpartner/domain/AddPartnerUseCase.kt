package com.example.myapplication.addpartner.domain

import com.example.myapplication.addpartner.domain.model.AddPartnerNetworkModel
import com.example.myapplication.partners.repository.PartnersRepository
import io.reactivex.Completable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AddPartnerUseCase @Inject constructor(
    private val partnersRepository: PartnersRepository
) {
    fun run(model: AddPartnerNetworkModel): Completable {
        return partnersRepository.addPartner(model)
    }
}