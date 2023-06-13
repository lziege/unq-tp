package io.paketo.demo.model

import io.paketo.demo.model.exceptions.DamageException
import io.paketo.demo.model.exceptions.InvalidNameException
import org.springframework.data.mongodb.core.mapping.Document
import javax.persistence.*

@Document
class Item {
    var name: String = "default-item-name"
    var damage: Int = 0
    var relatedClass: RPGClass? = null

    var ownerName: String = "Without owner"

    protected constructor()
    constructor(iName: String, iDamage: Int, iRPGClass: RPGClass) : this() {
        this.name = iName
        this.damage = iDamage
        this.relatedClass = iRPGClass

        // No es la mejor forma de solucionarlo, es únicamente un work-around
        if (damage < 1) throw DamageException()
        if (name.isBlank()) throw InvalidNameException(Item::class.java.simpleName)
    }

    @Id
    var id: String? = null

}

enum class RPGClass {
    MELEE, RANGED, TANK, MAGE, SUPPORT
}