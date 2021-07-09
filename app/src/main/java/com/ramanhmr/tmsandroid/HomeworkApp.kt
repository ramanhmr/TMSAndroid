package com.ramanhmr.tmsandroid

import android.app.Application
import androidx.room.Room
import com.ramanhmr.tmsandroid.homework14.SharedPrefsCandyUtils
import com.ramanhmr.tmsandroid.homework16.database.MessageDao
import com.ramanhmr.tmsandroid.homework16.database.MessageDatabase

class HomeworkApp : Application() {

    private val messageDatabase: MessageDatabase by lazy {
        Room.databaseBuilder(this, MessageDatabase::class.java, "message_database").build()
    }

    val messageDao: MessageDao by lazy { messageDatabase.messageDao() }

    override fun onCreate() {
        super.onCreate()

        SharedPrefsCandyUtils.sharedPrefs =
            applicationContext.getSharedPreferences(SharedPrefsCandyUtils.PREFS_KEY, MODE_PRIVATE)
    }
}