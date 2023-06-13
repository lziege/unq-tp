package io.paketo.demo.webservice.dto.request

import io.paketo.demo.model.RPGClass

class RequestItemDTO(
    var name: String,
    var damage: Int,
    var relatedClass: RPGClass
)
