package io.paketo.demo.service

import io.paketo.demo.model.Player

interface PlayerService : GenericService<Player> {
    fun addFriend(playerId: Long, friendId: Long)
    fun friends(playerId: Long) : List<Player>
}
