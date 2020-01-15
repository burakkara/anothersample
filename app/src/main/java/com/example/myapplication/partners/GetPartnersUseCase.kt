package com.example.myapplication.partners

import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetPartnersUseCase @Inject constructor(
    private val partnersRepository: PartnersRepository
) {
    fun run(): Single<List<PartnerViewModel>> {
        return partnersRepository.getPartners()
            //.map { it.mapNotNull { item -> item.description != null && item.id != null } }
            .map { partners -> partners.map(PartnerMapper::map) }
    }
}