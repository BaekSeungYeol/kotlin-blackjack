package blackjack

import blackjack.Fixtures.CARD_ACE
import blackjack.Fixtures.CARD_SEVEN
import blackjack.Fixtures.CARD_SIX
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class HitTest {

    @Test
    fun `14점`() {
        val hit = Hit(Hands(listOf(CARD_SIX, CARD_SEVEN)))
        val result = hit.draw(CARD_ACE)
        assertThat(result).isInstanceOf(Hit::class.java)
    }
}