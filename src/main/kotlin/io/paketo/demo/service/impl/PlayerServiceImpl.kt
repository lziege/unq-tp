package io.paketo.demo.service.impl

import io.paketo.demo.model.FriendshipNode
import io.paketo.demo.model.Player
import io.paketo.demo.persistence.FriendshipNodeDAO
import io.paketo.demo.persistence.PlayerDAO
import io.paketo.demo.service.PlayerService
import io.paketo.demo.service.TransactionalService
import org.springframework.beans.factory.annotation.Autowired
import java.lang.RuntimeException

@TransactionalService
class PlayerServiceImpl : PlayerService {
    @Autowired private lateinit var playerDAO : PlayerDAO
    @Autowired private lateinit var friendshipNodeDAO: FriendshipNodeDAO
    override fun save(entity: Player): Player {
        friendshipNodeDAO.save(FriendshipNode(entity.username))
        return playerDAO.save(entity)
    }

    override fun read(id: Long): Player {
        return playerDAO.getById(id)
    }

    override fun addFriend(playerId: Long, friendId: Long) {
        if (playerId == friendId) throw RuntimeException("A player can't be friend of herself </3")
        val player = read(playerId)
        val friend = read(friendId)

        if (friendshipNodeDAO.areFriends(player.username, friend.username)) throw RuntimeException("Those players are already friends")

        friendshipNodeDAO.addFriendRelationship(player.username, friend.username)
    }

    override fun friends(playerId: Long): List<Player> {
        val player = read(playerId)
        val friendsNames = friendshipNodeDAO.friends(player.username)

        return playerDAO.findAllByUsernameIn(friendsNames)
    }

}