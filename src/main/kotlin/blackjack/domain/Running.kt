package blackjack.domain

abstract class Running: State {

    override val isFinished: Boolean
        get() = false

    override fun stay(): State {
     return Stay()
    }
}