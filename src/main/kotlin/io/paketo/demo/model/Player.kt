package io.paketo.demo.model

import io.paketo.demo.model.exceptions.InvalidNameException
import javax.persistence.*

@Entity
class Player(@Column(unique = true, nullable = false) val nickname: String) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @ManyToMany (fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    val friends = mutableSetOf<Player>()
    var level = 1

    @ManyToOne
    var guild : Guild? = null

    fun addFriend(player: Player) {
        friends.add(player)
        player.friends.add(this)
    }

    fun updateGuild(guild: Guild) {
        this.guild = guild
    }

    init {
        if (nickname.isBlank()) { throw InvalidNameException(this.javaClass.simpleName) }
    }
}