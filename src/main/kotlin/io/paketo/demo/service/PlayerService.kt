package io.paketo.demo.service

import io.paketo.demo.model.Player

interface PlayerService : GenericService<Player> {
    fun addFriend(playerId: Long, friendId: Long)
}
