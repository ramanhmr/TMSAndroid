package com.ramanhmr.tmsandroid.homework14

import android.app.Application

class HomeworkApp : Application() {

    override fun onCreate() {
        super.onCreate()

        SharedPrefsCandyUtils.sharedPrefs =
            applicationContext.getSharedPreferences(SharedPrefsCandyUtils.PREFS_KEY, MODE_PRIVATE)
    }
}