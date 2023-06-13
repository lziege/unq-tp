package io.paketo.demo.service

import io.paketo.demo.model.Item
import io.paketo.demo.model.Player
import io.paketo.demo.model.RPGClass
import io.paketo.demo.service.ItemService
import io.paketo.demo.service.PlayerService
import io.paketo.demo.utils.Cleaner
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class NoSQLServicesTest {
    @Autowired private lateinit var playerService : PlayerService
    @Autowired private lateinit var itemService: ItemService
    @Autowired private lateinit var cleaner: Cleaner

    @Test
    fun item_SePersisteCorrectamenteUnItem() {
        val item = itemService.save(Item("Contrato Virtuoso", 120, RPGClass.MELEE))
        val itemRecuperado = itemService.read(item.id!!)

        Assertions.assertNotNull(item.id)
        Assertions.assertTrue(item.relatedClass == itemRecuperado.relatedClass)
        Assertions.assertTrue(item.name == itemRecuperado.name)
        Assertions.assertTrue(item.damage == itemRecuperado.damage)
        Assertions.assertTrue(item.id == itemRecuperado.id)
        Assertions.assertTrue(item !== itemRecuperado)
    }

    @Test
    fun item_SeAsignaCorrectamenteAUnJugador() {
        val player = playerService.save(Player("Type B Model 2"))
        val item = itemService.save(Item("Contrato Virtuoso", 120, RPGClass.MELEE))
        itemService.addItemToPlayer(item.id!!, player.id!!)

        val itemRecuperado = itemService.read(item.id!!)
        Assertions.assertEquals(player.nickname, itemRecuperado.ownerName)
    }

    @AfterEach
    fun clean() {
        cleaner.cleanDB()
    }
}