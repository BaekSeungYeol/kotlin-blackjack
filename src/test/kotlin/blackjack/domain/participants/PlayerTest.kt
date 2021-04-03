package blackjack.domain.participants

import blackjack.domain.CLUB_ACE
import blackjack.domain.CLUB_KING
import blackjack.domain.CLUB_TEN
import blackjack.domain.CLUB_TWO
import blackjack.domain.state.Bust
import blackjack.domain.winning.GameResult
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PlayerTest {

    @Test
    fun `블랙잭이 나온 상태에서는 드로우를 해도 무시해버림`() {
        val player = Player("John", arrayListOf(CLUB_ACE, CLUB_KING), 0.0)
        val beforeDrawScore = player.getScore()
        player.drawCard()
        val afterDrawScore = player.getScore()
        assertThat(beforeDrawScore).isEqualTo(afterDrawScore)
    }

    @Test
    fun `Hit 상태에서는 드로우를 진행`() {
        val player = Player("John", arrayListOf(CLUB_ACE, CLUB_TWO), 0.0)
        val beforeDrawScore = player.getScore()
        player.drawCard()
        val afterDrawScore = player.getScore()
        assertThat(beforeDrawScore).isNotEqualTo(afterDrawScore)
    }

    @Test
    fun `Bust 상태 확인`() {
        val player = Player("John", arrayListOf(CLUB_TEN, CLUB_KING), 0.0)
        player.drawCard()
        assertThat(player.state).isInstanceOf(Bust::class.java)
    }

    @Test
    fun `Bust상태에서는 패배처리`() {
        val player = Player("John", arrayListOf(CLUB_TEN, CLUB_KING), 0.0)
        val dealer = Dealer()
        player.drawCard()
        if (player.state is Bust) {
            assertThat(player.isWinning(dealer)).isEqualTo(GameResult.LOSE)
        }
    }

    @Test
    fun `BlackJack인 경우 승리`() {
        val player = Player("John", arrayListOf(CLUB_TEN, CLUB_ACE), 0.0)
        val dealer = Dealer()
        assertThat(player.isWinning(dealer)).isEqualTo(GameResult.WIN)
    }

    @Test
    fun `딜러와 플레이어 모두 BlackJack인 경우 무승부`() {
        val player = Player("John", arrayListOf(CLUB_TEN, CLUB_ACE), 0.0)
        val dealer = Dealer(initCards = arrayListOf(CLUB_TEN, CLUB_ACE))
        assertThat(player.isWinning(dealer)).isEqualTo(GameResult.DRAW)
    }
}
