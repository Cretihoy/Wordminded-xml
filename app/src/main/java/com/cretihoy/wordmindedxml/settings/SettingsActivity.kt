package com.cretihoy.wordmindedxml.settings

import android.os.Bundle
import com.cretihoy.wordmindedxml.R
import dagger.hilt.android.AndroidEntryPoint
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

@AndroidEntryPoint
class SettingsActivity : MvpAppCompatActivity(), SettingsView {

    @Inject
    lateinit var presenterProvider: Provider<SettingsPresenter>
    private val presenter by moxyPresenter { presenterProvider.get() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
    }
}