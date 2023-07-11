package blackjack.domain

object RandomCardGenerator {

    fun create() : PlayingCard {
        return PlayingCard.of(
            denomination = Denomination.getRandom(),
            suit = Suit.getRandom()
        )
    }
}
