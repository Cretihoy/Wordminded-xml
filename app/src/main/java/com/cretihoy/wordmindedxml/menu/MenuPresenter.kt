package com.cretihoy.wordmindedxml.menu

import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class MenuPresenter
@Inject constructor() : MvpPresenter<MenuView>() {

    fun openGameScreen() {
        viewState.openGameScreen()
    }

    fun openRulesScreen() {
        viewState.openRulesScreen()
    }

    fun openSettingsScreen() {
        viewState.openSettingsScreen()
    }
}