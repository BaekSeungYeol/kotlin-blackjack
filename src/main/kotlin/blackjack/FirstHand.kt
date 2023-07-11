package blackjack

class FirstHand(
    private val playingCard1: PlayingCard,
    private val playingCard2: PlayingCard
) {

    fun draw(): State {
        val firstHands = Hands(listOf(playingCard1, playingCard2))
        if(firstHands.isBlackjack) {
            return BlackJack()
        }
        return Hit(firstHands)
    }
}