package com.ramanhmr.tmsandroid.homework17.restApi

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object FiatCurrencyService {
    private const val BASE_URL = "https://pro-api.coinmarketcap.com"

    const val ID = "id"
    const val NAME = "name"
    const val DEFAULT_LIMIT = 20

    private fun getRetrofit() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(OkHttpClient.Builder().build())
        .build()

    fun getCurrencyService(): FiatCurrencyApi = getRetrofit().create(FiatCurrencyApi::class.java)
}