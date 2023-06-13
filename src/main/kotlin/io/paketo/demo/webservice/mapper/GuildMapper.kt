package io.paketo.demo.webservice.mapper

import io.paketo.demo.model.Guild
import io.paketo.demo.webservice.dto.response.GuildDTO

object GuildMapper {
    fun fromGuildToDTO(guild: Guild): GuildDTO {
        val members = guild.getMembers().map { p -> PlayerMapper.fromPlayerToDTO(p) }.toSet()
        return GuildDTO(guild.name, members)
    }
}