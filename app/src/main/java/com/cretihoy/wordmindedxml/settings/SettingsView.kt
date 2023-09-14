package com.cretihoy.wordmindedxml.settings

import moxy.MvpView
import moxy.viewstate.strategy.SkipStrategy
import moxy.viewstate.strategy.StateStrategyType

interface SettingsView : MvpView {

    @StateStrategyType(SkipStrategy::class)
    fun setInfinityGameSwitch(infinityGame: Boolean)
}