package blackjack

import blackjack.domain.Denomination
import blackjack.domain.PlayingCard
import blackjack.domain.Suit

object Fixtures {

    val CARD_ACE = PlayingCard.of(Denomination.ACE, Suit.SPADES)
    val CARD_TWO = PlayingCard.of(Denomination.TWO, Suit.SPADES)
    val CARD_THREE = PlayingCard.of(Denomination.THREE, Suit.SPADES)
    val CARD_SIX = PlayingCard.of(Denomination.SIX, Suit.SPADES)
    val CARD_SEVEN = PlayingCard.of(Denomination.SEVEN, Suit.SPADES)
    val CARD_TEN = PlayingCard.of(Denomination.TEN, Suit.SPADES)
    val CARD_JACK = PlayingCard.of(Denomination.JACK, Suit.SPADES)
}