package io.paketo.demo.service.impl

import io.paketo.demo.model.Guild
import io.paketo.demo.persistence.GuildDAO
import io.paketo.demo.persistence.PlayerDAO
import io.paketo.demo.service.GuildService
import io.paketo.demo.service.TransactionalService
import org.springframework.beans.factory.annotation.Autowired

@TransactionalService
class GuildServiceImpl : GuildService {
    @Autowired private lateinit var playerDAO: PlayerDAO
    @Autowired private lateinit var guildDAO: GuildDAO
    override fun save(entity: Guild): Guild {
        return guildDAO.save(entity)
    }

    override fun read(id: Long): Guild {
        return guildDAO.getById(id)
    }

    override fun addMember(guildId: Long, playerId: Long) {
        val guild = read(guildId)
        val player = playerDAO.getById(playerId)
        guild.addMember(player)
        save(guild)
    }

    override fun createGuild(name: String, playerId: Long): Guild {
        return save(Guild(name, playerDAO.getById(playerId)))
    }

}