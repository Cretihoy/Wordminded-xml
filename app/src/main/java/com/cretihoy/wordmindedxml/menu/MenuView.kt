package com.cretihoy.wordmindedxml.menu

import moxy.MvpView
import moxy.viewstate.strategy.SkipStrategy
import moxy.viewstate.strategy.StateStrategyType

interface MenuView : MvpView {

    @StateStrategyType(SkipStrategy::class)
    fun openGameScreen()

    @StateStrategyType(SkipStrategy::class)
    fun openRulesScreen()

    @StateStrategyType(SkipStrategy::class)
    fun openSettingsScreen()
}