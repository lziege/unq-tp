package io.paketo.demo.webservice.controller

import io.paketo.demo.model.Player
import io.paketo.demo.service.PlayerService
import io.paketo.demo.webservice.dto.response.PlayerDTO
import io.paketo.demo.webservice.mapper.PlayerMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@Controller
@CrossOrigin
@RequestMapping("/player")
@RestController
class PlayerController {
    @Autowired private lateinit var playerService: PlayerService

    @PostMapping("/register")
    fun register(@RequestParam username: String) : ResponseEntity<PlayerDTO> {
        return ResponseEntity.status(200).body(
            PlayerMapper.fromPlayerToDTO(playerService.save(Player(username)))
        )
    }

    @GetMapping("/{id}")
    fun recover(@PathVariable id: Long) : ResponseEntity<PlayerDTO> {
        return ResponseEntity.status(200).body(
            PlayerMapper.fromPlayerToDTO(playerService.read(id))
        )
    }

}