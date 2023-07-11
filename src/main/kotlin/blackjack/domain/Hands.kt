package blackjack.domain

data class Hands(
    private val cards: List<PlayingCard>
) {
    val isBlackjack: Boolean
        get() = calculate().isBlackjack
    val isBust: Boolean
        get() = calculate().isBust


    private fun calculate(): Score {
        val hasAce = _cards.any { it.isAce() }
        val score = Score(_cards.sumOf { it.score() })
        return score.addTenIfAce(hasAce)
    }
    private val _cards: MutableList<PlayingCard> = cards.toMutableList()

    fun add(card: PlayingCard) {
        _cards.add(card)
    }

    fun show(): String {
        return cards.joinToString(",") { it.show() }
    }


    companion object {
        private const val BLACKJACK_SCORE = 21
        private const val ADDITIONAL_SCORE = 10
    }
}