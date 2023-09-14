package com.cretihoy.wordmindedxml.game

import com.cretihoy.data.factory.QuestionFactory
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class GamePresenter
@Inject constructor(
    private val factory: QuestionFactory
) : MvpPresenter<GameView>() {

    fun onScreenClicked() {
        val task = factory.getRandomTask()
        val letter = factory.getRandomLetter()
        if (task != null && letter != null) {
            viewState.showQuestion(letter, task)
        } else {
            viewState.openEndGameScreen()
        }
    }
}