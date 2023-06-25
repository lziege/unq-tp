package io.paketo.demo.service

import io.paketo.demo.model.Guild

interface GuildService : GenericService<Guild> {
    fun addMember(guildId: Long, playerId: Long)
    fun createGuild(name: String, playerId: Long): Guild
}
