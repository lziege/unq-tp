package io.paketo.demo.service

import io.paketo.demo.model.Item

interface ItemService : MongoGenericService<Item> {
    fun deleteAll()
    fun addItemToPlayer(item: Item, playerId: Long) : Item
    fun itemsOf(username: String): List<Item>
}