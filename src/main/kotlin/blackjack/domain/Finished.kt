package blackjack.domain

abstract class Finished: State {

    override val isFinished: Boolean = true

    override fun draw(anotherCard: PlayingCard): State {
        throw IllegalStateException()
    }

    override fun stay(): State {
        throw IllegalStateException()
    }
}