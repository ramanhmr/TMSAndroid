package com.ramanhmr.tmsandroid

import android.app.Application
import androidx.room.Room
import com.ramanhmr.tmsandroid.homework14.SharedPrefsCandyUtils
import com.ramanhmr.tmsandroid.homework16.database.MessageDao
import com.ramanhmr.tmsandroid.homework16.database.MessageDatabase
import com.ramanhmr.tmsandroid.homework17.CurrencyRepository
import com.ramanhmr.tmsandroid.homework17.restApi.FiatCurrencyService

class HomeworkApp : Application() {

    private val messageDatabase: MessageDatabase by lazy {
        Room.databaseBuilder(this, MessageDatabase::class.java, "message_database").build()
    }

    val messageDao: MessageDao by lazy { messageDatabase.messageDao() }
    val currencyRepository by lazy { CurrencyRepository(FiatCurrencyService.getCurrencyService()) }

    override fun onCreate() {
        super.onCreate()

        SharedPrefsCandyUtils.sharedPrefs =
            applicationContext.getSharedPreferences(SharedPrefsCandyUtils.PREFS_KEY, MODE_PRIVATE)
    }
}