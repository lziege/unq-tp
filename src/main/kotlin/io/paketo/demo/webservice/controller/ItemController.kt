package io.paketo.demo.webservice.controller

import io.paketo.demo.model.Item
import io.paketo.demo.service.ItemService
import io.paketo.demo.webservice.dto.request.RequestItemDTO
import io.paketo.demo.webservice.mapper.ItemMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Controller
@CrossOrigin
@RequestMapping("/item")
@RestController
class ItemController {
    @Autowired private lateinit var itemService: ItemService

    @PostMapping("/addToPlayer/{playerId}")
    fun addToPlayer(@RequestBody item: RequestItemDTO, @PathVariable playerId: Long) : ResponseEntity<Item> {
        val createdItem = itemService.save(ItemMapper.fromDTOtoModel(item))
        return ResponseEntity.status(200).body(
            itemService.addItemToPlayer(createdItem.id!!, playerId)
        )
    }
}