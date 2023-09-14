package com.cretihoy.wordmindedxml.game

import com.cretihoy.data.model.LetterModel
import com.cretihoy.data.model.TaskModel
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.SkipStrategy
import moxy.viewstate.strategy.StateStrategyType

interface GameView : MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showQuestion(letter: LetterModel?, task: TaskModel?)

    @StateStrategyType(SkipStrategy::class)
    fun openEndGameScreen()
}