package com.example.myapplication.partners.domain.usecase

import com.example.myapplication.partners.domain.mapper.PartnerMapper
import com.example.myapplication.partners.PartnerViewModel
import com.example.myapplication.partners.repository.PartnersRepository
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetPartnersUseCase @Inject constructor(
    private val partnersRepository: PartnersRepository
) {
    fun run(): Single<List<PartnerViewModel>> {
        return partnersRepository.getPartners()
            .map { partners -> partners.map(PartnerMapper::map) }
    }
}