package com.cretihoy.wordmindedxml.game

import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class GamePresenter
@Inject constructor() : MvpPresenter<GameView>() {
}