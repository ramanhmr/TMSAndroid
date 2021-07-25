package com.ramanhmr.tmsandroid.homework20

import android.content.SharedPreferences

object SharedPrefsLocationUtils {
    lateinit var sharedPrefs: SharedPreferences
    const val PREFS_KEY = "PREFS_WEATHER"

    private const val PREFS_LOCATION = "LOCATION"

    fun putLocation(cityName: String) =
        sharedPrefs.edit().putString(PREFS_LOCATION, cityName).apply()

    fun getLocation() = sharedPrefs.getString(PREFS_LOCATION, null)
}