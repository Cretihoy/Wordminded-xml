package com.cretihoy.wordmindedxml.menu

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.cretihoy.data.storage.Storage
import com.cretihoy.wordmindedxml.R
import com.cretihoy.wordmindedxml.game.GameActivity
import com.cretihoy.wordmindedxml.rules.RulesActivity
import com.cretihoy.wordmindedxml.settings.SettingsActivity
import dagger.hilt.android.AndroidEntryPoint
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

@AndroidEntryPoint
class MenuActivity : MvpAppCompatActivity(), MenuView {

    private val buttonPlay: Button by lazy { findViewById(R.id.menu_button_play) }
    private val buttonRules: Button by lazy { findViewById(R.id.menu_button_rules) }
    private val buttonSettings: Button by lazy { findViewById(R.id.menu_button_settings) }

    @Inject
    lateinit var storage: Storage

    @Inject
    lateinit var presenterProvider: Provider<MenuPresenter>
    private val presenter by moxyPresenter { presenterProvider.get() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        storage.loadSettings(this)

        buttonPlay.setOnClickListener {
            presenter.openGameScreen()
        }
        buttonRules.setOnClickListener {
            presenter.openRulesScreen()
        }
        buttonSettings.setOnClickListener {
            presenter.openSettingsScreen()
        }
    }

    override fun onPause() {
        storage.saveSettings()
        super.onPause()
    }

    override fun openGameScreen() {
        val intent = Intent(this, GameActivity::class.java)
        startActivity(intent)
    }

    override fun openRulesScreen() {
        val intent = Intent(this, RulesActivity::class.java)
        startActivity(intent)
    }

    override fun openSettingsScreen() {
        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }
}