package com.ramanhmr.tmsandroid.homework20.restApi

import com.ramanhmr.tmsandroid.BuildConfig
import com.ramanhmr.tmsandroid.homework20.restApi.entities.WeatherResponseEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("/data/2.5/weather")
    suspend fun getWeather(
        @Query("q") cityName: String,
        @Query("appid") key: String = BuildConfig.WEATHER_API_KEY,
        @Query("units") units: String = WeatherApiService.UNITS_METRIC
    ): Response<WeatherResponseEntity>
}