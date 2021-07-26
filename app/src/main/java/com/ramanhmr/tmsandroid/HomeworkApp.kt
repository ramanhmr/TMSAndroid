package com.ramanhmr.tmsandroid

import android.app.AlarmManager
import android.app.Application
import android.content.Context
import androidx.room.Room
import com.ramanhmr.tmsandroid.homework14.SharedPrefsCandyUtils
import com.ramanhmr.tmsandroid.homework16.database.MessageDao
import com.ramanhmr.tmsandroid.homework16.database.MessageDatabase
import com.ramanhmr.tmsandroid.homework17.CurrencyRepository
import com.ramanhmr.tmsandroid.homework17.CurrencyViewModel
import com.ramanhmr.tmsandroid.homework17.restApi.FiatCurrencyService
import com.ramanhmr.tmsandroid.homework20.SharedPrefsLocationUtils
import com.ramanhmr.tmsandroid.homework20.WeatherViewModel
import com.ramanhmr.tmsandroid.homework20.restApi.WeatherApiService
import com.ramanhmr.tmsandroid.homework20.restApi.WeatherRepository
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
            modules(viewModels, storageModule, repositoryModule, systemModule)
        }

        SharedPrefsCandyUtils.sharedPrefs =
            applicationContext.getSharedPreferences(SharedPrefsCandyUtils.PREFS_KEY, MODE_PRIVATE)
        SharedPrefsLocationUtils.sharedPrefs =
            applicationContext.getSharedPreferences(
                SharedPrefsLocationUtils.PREFS_KEY,
                MODE_PRIVATE
            )
    }

    private val viewModels = module {
        viewModel { CurrencyViewModel(get()) }
        viewModel { WeatherViewModel(get()) }
    }

    private val repositoryModule = module {
        factory { CurrencyRepository(get()) }
        factory { WeatherRepository(get()) }
    }

    private val storageModule = module {
        factory { WeatherApiService.getWeatherService() }
        factory { FiatCurrencyService.getCurrencyService() }
    }

    private val systemModule = module {
        factory { get<Context>().getSystemService(ALARM_SERVICE) as AlarmManager }
    }
}