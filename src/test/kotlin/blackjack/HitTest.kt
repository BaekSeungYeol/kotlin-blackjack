package blackjack

import blackjack.Fixtures.CARD_ACE
import blackjack.Fixtures.CARD_JACK
import blackjack.Fixtures.CARD_SEVEN
import blackjack.Fixtures.CARD_SIX
import blackjack.Fixtures.CARD_THREE
import blackjack.Fixtures.CARD_TWO
import blackjack.domain.BlackJack
import blackjack.domain.Bust
import blackjack.domain.Hands
import blackjack.domain.Hit
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class HitTest {

    @Test
    fun `14점 Hit`() {
        val hit = Hit(Hands(listOf(CARD_SIX, CARD_SEVEN)))
        val result = hit.draw(CARD_ACE)
        assertThat(result).isInstanceOf(Hit::class.java)
    }
    @Test
    fun `21점 Blackjack`() {
        val hit = Hit(Hands(listOf(CARD_SIX, CARD_SEVEN)))
        hit.draw(CARD_SIX)
        val result = hit.draw(CARD_TWO)
        assertThat(result).isInstanceOf(BlackJack::class.java)
    }

    @Test
    fun `21점 Blackjack 2`() {
        val hit = Hit(Hands(listOf(CARD_ACE, CARD_SEVEN)))
        val result = hit.draw(CARD_THREE)
        assertThat(result).isInstanceOf(BlackJack::class.java)
    }

    @Test
    fun `23점 Bust`() {
        val hit = Hit(Hands(listOf(CARD_SIX, CARD_SEVEN)))
        val result = hit.draw(CARD_JACK)
        assertThat(result).isInstanceOf(Bust::class.java)
    }
}