package com.ramanhmr.tmsandroid.homework20.restApi

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object WeatherApiService {
    private const val BASE_URL = "https://api.openweathermap.org"

    const val UNITS_METRIC = "metric"

    private fun getRetrofit() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(OkHttpClient.Builder().build())
        .build()

    fun getWeatherService(): WeatherApi = getRetrofit().create(WeatherApi::class.java)
}