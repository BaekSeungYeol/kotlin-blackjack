package blackjack.domain

class Score(
    private val score: Int
) {

    val isBlackjack = score == BLACKJACK_SCORE
    val isBust = score > BLACKJACK_SCORE

    fun addTenIfAce(hasAce: Boolean): Score {
        if(hasAce && score + ADDITIONAL_SCORE <= BLACKJACK_SCORE) {
            return Score(score + ADDITIONAL_SCORE)
        }
        return this
    }

    companion object {
        private const val BLACKJACK_SCORE = 21
        private const val ADDITIONAL_SCORE = 10
    }
}
