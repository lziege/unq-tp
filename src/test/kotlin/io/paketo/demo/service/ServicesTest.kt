package io.paketo.demo.service

import io.paketo.demo.model.Guild
import io.paketo.demo.model.Item
import io.paketo.demo.model.Player
import io.paketo.demo.model.RPGClass
import io.paketo.demo.utils.Cleaner
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ServicesTest {
    @Autowired private lateinit var playerService : PlayerService
    @Autowired private lateinit var guildService : GuildService
    @Autowired private lateinit var itemService: ItemService
    @Autowired private lateinit var cleaner: Cleaner

    @Test
    fun player_SeCreaCorrectamente() {
        val maguito = playerService.save(Player("Maguito"))
        Assertions.assertNotNull(maguito.id)
    }

    @Test
    fun guild_SeCreaCorrectamente() {
        val maguito = Player("Maguito")
        val guild = guildService.save(Guild("Hogwarts", maguito))
        Assertions.assertNotNull(guild.id)
        Assertions.assertNotNull(maguito.id)
    }

    @Test
    fun player_SeAñadenCorrectamenteComoAmigos() {
        val maguito = playerService.save(Player("Maguito"))
        val arquero = playerService.save(Player("Arquero"))
        playerService.addFriend(maguito.id!!, arquero.id!!)

        val maguitoRecuperado = playerService.read(maguito.id!!)
        val arqueroRecuperado = playerService.read(arquero.id!!)

        Assertions.assertTrue(maguitoRecuperado.friends.any { p -> p.nickname == "Arquero" })
        Assertions.assertTrue(arqueroRecuperado.friends.any { p -> p.nickname == "Maguito" })
    }

    @AfterEach
    fun cleanDB() {
        cleaner.cleanDB()
    }

}
