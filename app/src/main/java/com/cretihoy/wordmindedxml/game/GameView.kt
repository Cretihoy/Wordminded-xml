package com.cretihoy.wordmindedxml.game

import com.cretihoy.data.model.LetterModel
import com.cretihoy.data.model.TaskModel
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

interface GameView : MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showQuestions(letter: LetterModel?, task: TaskModel?)
}