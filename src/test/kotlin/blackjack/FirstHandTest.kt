package blackjack

import blackjack.domain.BlackJack
import blackjack.domain.FirstHand
import blackjack.domain.Hit
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FirstHandTest {

    @Test
    fun `hit`() {
        val firstHand = FirstHand(Fixtures.CARD_SEVEN, Fixtures.CARD_SIX)
        val result = firstHand.draw()
        assertThat(result).isInstanceOf(Hit::class.java)
    }


    @Test
    fun `blackjack`() {
        val firstHand = FirstHand(Fixtures.CARD_ACE, Fixtures.CARD_JACK)
        val result = firstHand.draw()
        assertThat(result).isInstanceOf(BlackJack::class.java)
    }
}