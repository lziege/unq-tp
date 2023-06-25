package io.paketo.demo.webservice.controller

import io.paketo.demo.model.Player
import io.paketo.demo.service.ItemService
import io.paketo.demo.service.PlayerService
import io.paketo.demo.webservice.dto.PlayerDTO
import io.paketo.demo.webservice.mapper.PlayerMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@CrossOrigin
@RequestMapping("/player")
@RestController
class PlayerController {
    @Autowired private lateinit var playerService: PlayerService
    @Autowired private lateinit var itemService: ItemService

    @PostMapping("/register/{username}")
    fun register(@PathVariable username: String) : ResponseEntity<Player> {
        return ResponseEntity.status(200).body(
            playerService.save(Player(username))
        )
    }

    @GetMapping("/{id}")
    fun recover(@PathVariable id: Long) : ResponseEntity<PlayerDTO> {
        val p = playerService.read(id)
        val i = itemService.itemsOf(p.username)
        return ResponseEntity.status(200).body(
            PlayerMapper.fromPlayerToDTO(p, i)
        )
    }

    @PostMapping("/addFriend/{playerId}/{friendId}")
    fun addFriend(@PathVariable playerId: Long, @PathVariable friendId: Long) : ResponseEntity<Any> {
        playerService.addFriend(playerId, friendId)
        return ResponseEntity.status(200).body(
            "The player ${playerService.read(playerId).username} is now friend of ${playerService.read(friendId).username}"
        )
    }

    @GetMapping("/friendsOf/{id}")
    fun friends(@PathVariable id: Long) : ResponseEntity<Any> {
        return ResponseEntity.status(200).body(
            playerService.friends(id).map { p -> PlayerMapper.fromPlayerToSampleDTO(p) }
        )
    }

}