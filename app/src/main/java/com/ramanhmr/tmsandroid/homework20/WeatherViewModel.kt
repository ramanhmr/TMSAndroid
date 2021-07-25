package com.ramanhmr.tmsandroid.homework20

import androidx.lifecycle.ViewModel
import com.ramanhmr.tmsandroid.homework20.restApi.WeatherRepository
import com.ramanhmr.tmsandroid.homework20.restApi.entities.Weather
import kotlinx.coroutines.runBlocking

class WeatherViewModel(private val weatherRepository: WeatherRepository) : ViewModel() {

    fun getWeather(cityName: String): Weather? =
        runBlocking { weatherRepository.getWeather(cityName) }

    fun hasCity(cityName: String): Boolean = runBlocking { weatherRepository.hasCity(cityName) }

    fun saveCity(cityName: String) = SharedPrefsLocationUtils.putLocation(cityName)
}