package io.paketo.demo.webservice.controller

import io.paketo.demo.service.GuildService
import io.paketo.demo.webservice.mapper.GuildMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@CrossOrigin
@RequestMapping("/guild")
@RestController
class GuildController {
    @Autowired private lateinit var guildService: GuildService

    @PostMapping("/create/{playerId}/{guildName}")
    fun createGuild(@PathVariable playerId: Long, @PathVariable guildName: String) : ResponseEntity<Any> {
        return ResponseEntity.ok().body(
            GuildMapper.fromGuildToDTO(guildService.createGuild(guildName, playerId))
        )
    }

    @PostMapping("/addMember/{guildId}/{playerId}")
    fun addMember(@PathVariable guildId: Long, @PathVariable playerId: Long) : ResponseEntity<Any> {
        return ResponseEntity.ok().body(
            guildService.addMember(guildId, playerId)
        )
    }

    @GetMapping("/{id}")
    fun getGuild(@PathVariable guildId: Long): ResponseEntity<Any> {
        return ResponseEntity.ok().body(
            GuildMapper.fromGuildToDTO(guildService.read(guildId))
        )
    }

}