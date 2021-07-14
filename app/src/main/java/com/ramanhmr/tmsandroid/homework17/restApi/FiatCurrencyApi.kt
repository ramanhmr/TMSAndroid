package com.ramanhmr.tmsandroid.homework17.restApi

import com.ramanhmr.tmsandroid.homework17.response.FiatResponseEntity
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface FiatCurrencyApi {

    @Headers("X-CMC_PRO_API_KEY: ${FiatCurrencyService.API_KEY}")
    @GET("v1/fiat/map")
    suspend fun getFiatCurrencyList(
        @Query("limit") limit: Int = 20,
        @Query("sort") sort: String = FiatCurrencyService.ID
    ): FiatResponseEntity
}