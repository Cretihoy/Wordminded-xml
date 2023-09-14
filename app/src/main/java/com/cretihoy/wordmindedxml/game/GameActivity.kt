package com.cretihoy.wordmindedxml.game

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import com.cretihoy.data.model.LetterModel
import com.cretihoy.data.model.TaskModel
import com.cretihoy.wordmindedxml.R
import com.cretihoy.wordmindedxml.endGame.EndGameActivity
import dagger.hilt.android.AndroidEntryPoint
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

@AndroidEntryPoint
class GameActivity : MvpAppCompatActivity(), GameView {

    private val letterTop: TextView by lazy { findViewById(R.id.game_letter_top) }
    private val taskTop: TextView by lazy { findViewById(R.id.game_task_top) }
    private val taskBottom: TextView by lazy { findViewById(R.id.game_task_bottom) }
    private val letterBottom: TextView by lazy { findViewById(R.id.game_letter_bottom) }
    private val gameScreen: LinearLayout by lazy { findViewById(R.id.game_screen) }

    @Inject
    lateinit var presenterProvider: Provider<GamePresenter>
    private val presenter by moxyPresenter { presenterProvider.get() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        gameScreen.setOnClickListener {
            presenter.onScreenClicked()
        }
    }

    override fun showQuestion(letter: LetterModel?, task: TaskModel?) {
        letterTop.text = letter?.let { getString(it.letter) }
        taskTop.text = task?.let { getString(it.task) }
        taskBottom.text = task?.let { getString(it.task) }
        letterBottom.text = letter?.let { getString(it.letter) }
    }

    override fun openEndGameScreen() {
        val intent = Intent(this, EndGameActivity::class.java)
        startActivity(intent)
    }
}