package com.ramanhmr.tmsandroid.homework20.restApi

import com.ramanhmr.tmsandroid.homework20.restApi.entities.Weather
import com.ramanhmr.tmsandroid.homework20.restApi.entities.WeatherResponseEntity
import kotlin.math.roundToInt

class WeatherRepository(private val weatherApi: WeatherApi) {

    suspend fun getWeather(cityName: String): Weather? =
        weatherApi.getWeather(cityName).body()?.toWeather()

    suspend fun hasCity(cityName: String): Boolean = weatherApi.getWeather(cityName).isSuccessful

    private fun WeatherResponseEntity.toWeather(): Weather {
        val temperature = this.main.temp.roundToInt()
        return Weather(
            StringBuilder().append(if (temperature >= 0) "+" else "")
                .append(temperature)
                .append("\u2103")
                .toString(),
            this.weather[0].description,
            StringBuilder().append(this.wind.speed).append(" m/s").toString(),
            when (this.wind.deg) {
                in 23..67 -> "NE"
                in 68..112 -> "E"
                in 113..157 -> "SE"
                in 158..202 -> "S"
                in 203..247 -> "SW"
                in 248..292 -> "W"
                in 293..337 -> "NW"
                else -> "N"
            },
            this.name
        )
    }
}