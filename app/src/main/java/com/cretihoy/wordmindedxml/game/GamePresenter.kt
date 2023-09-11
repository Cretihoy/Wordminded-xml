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

    val letter = factory.getRandomLetter()
    val task = factory.getRandomTask()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        showQuestion()
    }

    private fun showQuestion() {
        viewState.showQuestions(letter, task)
    }
}