package com.example.myapplication.partners

import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PartnersRepositoryImpl @Inject constructor(private val api: Api) : PartnersRepository {
    override fun getPartners(): Single<List<PartnerNetworkModel>> {
        return api.getPartners()
    }
}