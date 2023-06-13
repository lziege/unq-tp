package io.paketo.demo.service.impl

import io.paketo.demo.model.Player
import io.paketo.demo.persistence.PlayerDAO
import io.paketo.demo.service.GenericService
import io.paketo.demo.service.PlayerService
import io.paketo.demo.service.TransactionalService
import org.springframework.beans.factory.annotation.Autowired

@TransactionalService
class PlayerServiceImpl : PlayerService {
    @Autowired private lateinit var playerDAO : PlayerDAO
    override fun save(entity: Player): Player {
        return playerDAO.save(entity)
    }

    override fun read(id: Long): Player {
        return playerDAO.getById(id)
    }

    override fun addFriend(playerId: Long, friendId: Long) {
        val player = read(playerId)
        val friend = read(friendId)

        player.addFriend(friend)
        save(player)
    }

}