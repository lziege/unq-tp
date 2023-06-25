package io.paketo.demo.utils

import io.paketo.demo.model.Item
import io.paketo.demo.model.Player
import io.paketo.demo.model.RPGClass
import io.paketo.demo.service.GuildService
import io.paketo.demo.service.ItemService
import io.paketo.demo.service.PlayerService
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DataCreation {
    /*
    * ==== IMPORTANTE:
    * Estas son funciones para generar datos y ver la base con un estado específico.
    * No son implementaciones de un DataService ni tests en sí.
    * */

    @Autowired private lateinit var playerService : PlayerService
    @Autowired private lateinit var guildService : GuildService
    @Autowired private lateinit var itemService: ItemService
    @Autowired private lateinit var cleaner: Cleaner

    @Test
    fun initServerOnline() {
        // Guild de EPERS: unos docentes copados que dan clases en la UNQ
        val saved = createPlayers()
        itemService.addItemToPlayer(Item("Pergamino de Conocimiento Infinito", 999, RPGClass.MAGE), saved["r"]!!.id!!)
        itemService.addItemToPlayer(Item("Escudo de Juegos de Mesa Antiguo", 0, RPGClass.TANK),saved["i"]!!.id!!)
        itemService.addItemToPlayer(Item("Dragonslayer", 150, RPGClass.MELEE),saved["i"]!!.id!!)
        itemService.addItemToPlayer(Item("Daga de la Discordia", 90, RPGClass.MELEE),saved["t"]!!.id!!)
        itemService.addItemToPlayer(Item("Detector de Anomalías", 0, RPGClass.SUPPORT),saved["l"]!!.id!!)
        itemService.addItemToPlayer(Item("Bombas Aromáticas de Java", 40, RPGClass.RANGE),saved["v"]!!.id!!)
        itemService.addItemToPlayer(Item("Libro de Versos Sellados", 29, RPGClass.MAGE),saved["f"]!!.id!!)

        val epers = guildService.createGuild("EPERS", saved["r"]!!.id!!)
        val asList : List<Player> = saved.values.toList()
        for (i in IntRange(1,5)) { guildService.addMember(epers.id!!, asList[i].id!!) }

        for (i in IntRange(0,5)) {
            var j = i
            while (j < 5) {
                playerService.addFriend(asList[i].id!!, asList[j+1].id!!)
                j++
            }
        }

    }

    @Test
    fun clear() { cleaner.cleanDB() }

    private fun createPlayers(): MutableMap<String, Player> {
        val map = mutableMapOf<String, Player>()
        map["r"] = playerService.save(Player("Ronny, el Sabio").apply { level = 100 })
        map["i"] = playerService.save(Player("Ivar, el Gigante").apply { level = 85 })
        map["t"] = playerService.save(Player("Tobi, el Arlequín").apply { level = 85 })
        map["l"] = playerService.save(Player("LuQA, el Detector").apply { level = 30 })
        map["v"] = playerService.save(Player("Valen, el Picaro").apply { level = 30 })
        map["f"] = playerService.save(Player("Franco, el Mal afortunado").apply { level = 30 })
        return map
    }
}