package io.paketo.demo.service.impl

import io.paketo.demo.model.Item
import io.paketo.demo.persistence.ItemDAO
import io.paketo.demo.persistence.PlayerDAO
import io.paketo.demo.service.ItemService
import io.paketo.demo.service.TransactionalService
import org.springframework.beans.factory.annotation.Autowired

@TransactionalService
class ItemServiceImpl : ItemService {
    @Autowired private lateinit var itemDAO: ItemDAO
    @Autowired private lateinit var playerDAO: PlayerDAO
    override fun save(entity: Item): Item {
        return itemDAO.save(entity)
    }

    override fun read(id: String): Item {
        return itemDAO.findById(id).get()
    }

    override fun deleteAll() = itemDAO.deleteAll()
    override fun addItemToPlayer(item: Item, playerId: Long): Item {
        item.ownerName = playerDAO.getById(playerId).username
        return itemDAO.save(item)
    }

    override fun itemsOf(username: String): List<Item> {
        return itemDAO.findByOwnerName(username)
    }
}