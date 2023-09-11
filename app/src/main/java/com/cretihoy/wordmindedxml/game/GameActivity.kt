package com.cretihoy.wordmindedxml.game

import android.os.Bundle
import android.widget.TextView
import com.cretihoy.wordmindedxml.R
import dagger.hilt.android.AndroidEntryPoint
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

@AndroidEntryPoint
class GameActivity : MvpAppCompatActivity(), GameView {

    val letterTop: TextView by lazy { findViewById(R.id.game_letter_top) }
    val questionTop: TextView by lazy { findViewById(R.id.game_task_top) }
    val questionBottom: TextView by lazy { findViewById(R.id.game_task_bottom) }
    val letterBottom: TextView by lazy { findViewById(R.id.game_letter_bottom) }

    @Inject
    lateinit var presenterProvider: Provider<GamePresenter>
    private val presenter by moxyPresenter { presenterProvider.get() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
    }
}