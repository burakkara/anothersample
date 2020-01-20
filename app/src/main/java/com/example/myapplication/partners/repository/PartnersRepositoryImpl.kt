package com.example.myapplication.partners.repository

import com.example.myapplication.addpartner.domain.model.AddPartnerNetworkModel
import com.example.myapplication.addpartner.domain.model.AddPartnerRequest
import com.example.myapplication.partners.domain.model.PartnerNetworkModel
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PartnersRepositoryImpl @Inject constructor(private val api: Api) :
    PartnersRepository {
    override fun getPartners(): Single<List<PartnerNetworkModel>> {
        return api.getPartners()
    }

    override fun addPartner(model: AddPartnerNetworkModel): Completable {
        return api.addPartner(AddPartnerRequest(model.name, model.description))
    }
}