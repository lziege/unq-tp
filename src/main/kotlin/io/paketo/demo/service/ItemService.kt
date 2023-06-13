package io.paketo.demo.service

import io.paketo.demo.model.Item

interface ItemService : MongoGenericService<Item> {
    fun deleteAll()
    fun addItemToPlayer(itemId: String, playerId: Long) : Item
}