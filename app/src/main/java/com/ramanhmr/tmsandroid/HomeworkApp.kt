package com.ramanhmr.tmsandroid

import android.app.Application
import androidx.room.Room
import com.ramanhmr.tmsandroid.homework14.SharedPrefsCandyUtils
import com.ramanhmr.tmsandroid.homework16.database.MessageDao
import com.ramanhmr.tmsandroid.homework16.database.MessageDatabase
import com.ramanhmr.tmsandroid.homework17.CurrencyRepository
import com.ramanhmr.tmsandroid.homework17.CurrencyViewModel
import com.ramanhmr.tmsandroid.homework17.restApi.FiatCurrencyService
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class HomeworkApp : Application() {

    private val messageDatabase: MessageDatabase by lazy {
        Room.databaseBuilder(this, MessageDatabase::class.java, "message_database").build()
    }

    val messageDao: MessageDao by lazy { messageDatabase.messageDao() }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@HomeworkApp)
            modules(listOf(viewModels, storageModule, repositoryModule))
        }

        SharedPrefsCandyUtils.sharedPrefs =
            applicationContext.getSharedPreferences(SharedPrefsCandyUtils.PREFS_KEY, MODE_PRIVATE)
    }

    private val viewModels = module {
        viewModel { CurrencyViewModel(get()) }
    }

    private val repositoryModule = module {
        factory { CurrencyRepository(get()) }
    }

    private val storageModule = module {
        factory { FiatCurrencyService.getCurrencyService() }
    }
}