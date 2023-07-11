package blackjack.domain

import kotlin.random.Random

enum class Suit {
    DIAMOND,
    HEART,
    SPADES,
    CLUBS;

    companion object {
        fun getRandom(): Suit {
            return values()[Random.nextInt(values().size-1)
            ]
        }
    }
}