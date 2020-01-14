package com.example.myapplication.partners

import com.example.myapplication.Mapper

object PartnerMapper : Mapper<PartnerNetworkModel, PartnerViewModel> {
    override fun map(from: PartnerNetworkModel): PartnerViewModel {
        return PartnerViewModel(from.name, from.description, from.imageUrl)
    }
}