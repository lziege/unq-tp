package io.paketo.demo.webservice.mapper

import io.paketo.demo.model.Player
import io.paketo.demo.webservice.dto.response.PlayerDTO

object PlayerMapper {
    fun fromPlayerToDTO(player: Player) = PlayerDTO(player.id!!, player.nickname, player.level)
}