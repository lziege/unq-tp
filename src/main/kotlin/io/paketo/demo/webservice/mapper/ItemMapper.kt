package io.paketo.demo.webservice.mapper

import io.paketo.demo.model.Item
import io.paketo.demo.webservice.dto.request.RequestItemDTO


object ItemMapper {
    fun fromDTOtoModel(dto: RequestItemDTO) : Item {
        return Item(dto.name, dto.damage, dto.relatedClass)
    }
}