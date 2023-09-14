package com.cretihoy.wordmindedxml.settings

import com.cretihoy.data.storage.Storage
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class SettingsPresenter
@Inject constructor(
    private val storage: Storage
) : MvpPresenter<SettingsView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setInfinityGameSwitch(storage.isInfinityGame)
    }

    fun onInfinityGameSwitchToggled(isEnabled: Boolean) {
        storage.isInfinityGame = isEnabled
        storage.saveSettings()
    }
}