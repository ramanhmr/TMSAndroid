package com.ramanhmr.tmsandroid.homework14

import android.content.SharedPreferences

object SharedPrefsCandyUtils {
    lateinit var sharedPrefs: SharedPreferences
    const val PREFS_KEY = "PREFS_CANDY"

    private const val PREFS_CODE_KEY = "PREFS_CODE_KEY"
    private const val PREFS_BRAND_KEY = "PREFS_BRAND_KEY"

    fun hasBrandAndCode() =
        sharedPrefs.contains(PREFS_CODE_KEY) && sharedPrefs.contains(PREFS_BRAND_KEY)

    fun putCode(value: Int) {
        sharedPrefs.edit().putInt(PREFS_CODE_KEY, value).commit()
    }

    fun putBrand(value: String) {
        sharedPrefs.edit().putString(PREFS_BRAND_KEY, value).commit()
    }

    fun getCode() = sharedPrefs.getInt(PREFS_CODE_KEY, -1)

    fun getBrand() = sharedPrefs.getString(PREFS_BRAND_KEY, "")
}