package blackjack

class Hands(
    private val cards: List<PlayingCard>
) {
    val isBlackjack: Boolean
        get() = calculate() == BLACKJACK_SCORE
    val isBust: Boolean
        get() = calculate() > BLACKJACK_SCORE

    private fun calculate(): Int {
        val hasAce = _cards.any { it.isAce() }
        var score = cards.sumOf { it.score() }
        if(hasAce) {
           score += ADDITIONAL_SCORE
        }
        return score
    }
    private val _cards: MutableList<PlayingCard> = cards.toMutableList()

    fun add(card: PlayingCard) {
        _cards.add(card)
    }

    companion object {
        private const val BLACKJACK_SCORE = 21
        private const val ADDITIONAL_SCORE = 10
    }
}