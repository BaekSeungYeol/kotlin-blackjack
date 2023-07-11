package blackjack.domain

data class PlayingCard(
    private val denomination: Denomination,
    val suit: Suit
) {

    fun isAce(): Boolean = denomination == Denomination.ACE
    fun score(): Int = denomination.number

    fun show(): String {
        return "(${denomination.name})${suit.name}"
    }
    companion object {
        fun of(denomination: Denomination, suit: Suit) : PlayingCard {
            return PlayingCard(denomination, suit)
        }
    }
}