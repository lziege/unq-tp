package io.paketo.demo.webservice

import io.paketo.demo.model.generator.ModelGenerator
import io.paketo.demo.webservice.mapper.GuildMapper
import io.paketo.demo.webservice.mapper.PlayerMapper
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Controller
@CrossOrigin
@RequestMapping("/testing")
@RestController
class ExampleController {
    @GetMapping("/guild")
    fun guild() : ResponseEntity<Any> {
        return ResponseEntity.status(200).body(GuildMapper.fromGuildToDTO(ModelGenerator.epersGuild()))
    }

    @GetMapping("/devs")
    fun devs() : ResponseEntity<Any> {
        val players = ModelGenerator.epersPlayers.map { p -> PlayerMapper.fromPlayerToDTO(p) }
        return ResponseEntity.status(200).body(players)
    }
}