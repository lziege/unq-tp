package io.paketo.demo.webservice.dto.response

data class GuildDTO(
    val name: String,
    val members: Set<PlayerDTO>
)
