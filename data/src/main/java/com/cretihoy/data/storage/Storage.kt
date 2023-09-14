package com.cretihoy.data.storage

import android.app.Activity
import android.content.Context
import javax.inject.Inject

private const val PREFERENCES_KEY = "Wordminded"
private const val INFINITY_GAME_KEY = "infinityGame"

class Storage
@Inject constructor() {

    var savedActivity: Activity? = null
    var isInfinityGame = false

    fun loadSettings(activity: Activity) {
        savedActivity = activity
        val preferences = activity.getSharedPreferences(PREFERENCES_KEY, Context.MODE_PRIVATE)
        isInfinityGame = preferences.getBoolean(INFINITY_GAME_KEY, false)
    }

    fun saveSettings() {
        savedActivity?.let {
            val preferences = it.getSharedPreferences(PREFERENCES_KEY, Context.MODE_PRIVATE)
            preferences.edit().putBoolean(INFINITY_GAME_KEY, isInfinityGame).apply()
        }
    }

    fun resetSettings() {
        isInfinityGame = false
        saveSettings()
    }
}