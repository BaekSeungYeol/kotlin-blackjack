package blackjack

class PlayingCard(
    private val denomination: Denomination,
    val suit: Suit
) {

    fun isAce(): Boolean = denomination == Denomination.ACE
    fun score(): Int = denomination.number

    companion object {
        fun of(denomination: Denomination, suit: Suit) : PlayingCard {
            return PlayingCard(denomination, suit)
        }
    }
}