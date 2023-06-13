package io.paketo.demo.service.impl

import io.paketo.demo.model.Guild
import io.paketo.demo.persistence.GuildDAO
import io.paketo.demo.service.GenericService
import io.paketo.demo.service.GuildService
import io.paketo.demo.service.TransactionalService
import org.springframework.beans.factory.annotation.Autowired

@TransactionalService
class GuildServiceImpl : GuildService {
    @Autowired
    private lateinit var guildDAO: GuildDAO
    override fun save(entity: Guild): Guild {
        return guildDAO.save(entity)
    }

    override fun read(id: Long): Guild {
        return guildDAO.getById(id)
    }

}