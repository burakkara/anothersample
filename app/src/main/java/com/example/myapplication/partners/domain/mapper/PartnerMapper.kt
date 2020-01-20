package com.example.myapplication.partners.domain.mapper

import com.example.myapplication.architecture.adapter.Mapper
import com.example.myapplication.partners.domain.model.PartnerNetworkModel
import com.example.myapplication.partners.PartnerViewModel

object PartnerMapper :
    Mapper<PartnerNetworkModel, PartnerViewModel> {
    override fun map(from: PartnerNetworkModel): PartnerViewModel {
        return PartnerViewModel(
            from.id,
            from.name,
            from.description,
            from.imageUrl
        )
    }
}