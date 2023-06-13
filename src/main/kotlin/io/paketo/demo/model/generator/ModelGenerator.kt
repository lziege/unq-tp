package io.paketo.demo.model.generator

import io.paketo.demo.model.Guild
import io.paketo.demo.model.Player

object ModelGenerator {
    val epersPlayers = listOf(
        Player("Ronny, el Sabio").apply { level = 100 },
        Player("Ivar, el Gigante").apply { level = 85 },
        Player("Tobi, el Arlequín").apply { level = 85 },
        Player("LuQA, el Detector").apply { level = 30 },
        Player("Valen, el Picaro").apply { level = 30 },
        Player("Franco, el Constructor").apply { level = 30 }
    )

    fun epersGuild(): Guild {
//        Creación de EPERS
        val epers = Guild("EPERS Team", epersPlayers[0])
//        Se añaden miembros a EPERS
        epers.addMember(epersPlayers[1])
        epers.addMember(epersPlayers[2])
        epers.addMember(epersPlayers[3])
        epers.addMember(epersPlayers[4])
        epers.addMember(epersPlayers[5])
        return epers
    }
}