package blackjack.domain

interface State {
    val isFinished: Boolean
    fun draw(anotherCard: PlayingCard): State
    fun stay(): State

}