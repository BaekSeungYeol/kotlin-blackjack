package blackjack.ui

import blackjack.domain.Hands
import blackjack.domain.Player
import blackjack.domain.RandomCardGenerator

class BlackJackController {

    fun startGame() {
        println("게임에 참여할 사람의 이름을 입력하세요. ( 쉼표 기준으로 분리 )")
        val players: List<Player> = readln().trim().split(",").map { name ->
            Player(
                name = name,
                hands = Hands(
                    listOf(
                        RandomCardGenerator.create(),
                        RandomCardGenerator.create(),
                    )
                )
            )
        }
        println("${players.joinToString(",") { it.name }}에게 2장의 카드를 나누었습니다.")
        players.forEach { player ->
            println("${player.name}카드: ${player.hands.show()}")
        }
    }
}