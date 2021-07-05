package com.ramanhmr.tmsandroid

import android.app.Application
import com.ramanhmr.tmsandroid.homework14.SharedPrefsCandyUtils

class HomeworkApp : Application() {

    override fun onCreate() {
        super.onCreate()

        SharedPrefsCandyUtils.sharedPrefs =
            applicationContext.getSharedPreferences(SharedPrefsCandyUtils.PREFS_KEY, MODE_PRIVATE)
    }
}