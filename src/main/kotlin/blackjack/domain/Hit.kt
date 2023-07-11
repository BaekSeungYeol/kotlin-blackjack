package blackjack.domain

class Hit(
    private val hands: Hands
): Running() {

    override fun draw(anotherCard: PlayingCard): State {
        hands.add(anotherCard)

        if(hands.isBlackjack) {
            return BlackJack()
        }
        if(hands.isBust) {
            return Bust()
        }

        return Hit(hands)
    }

    companion object {
        private const val BLACKJACK_SCORE = 21
        private const val ADDITIONAL_SCORE = 10
    }
}