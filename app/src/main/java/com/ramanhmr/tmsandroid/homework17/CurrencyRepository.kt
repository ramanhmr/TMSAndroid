package com.ramanhmr.tmsandroid.homework17

import com.ramanhmr.tmsandroid.homework17.response.FiatResponseEntity
import com.ramanhmr.tmsandroid.homework17.restApi.FiatCurrencyApi
import com.ramanhmr.tmsandroid.homework17.restApi.FiatCurrencyService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CurrencyRepository(private val currencyApi: FiatCurrencyApi) {

    suspend fun getCurrencies(
        limit: Int = FiatCurrencyService.DEFAULT_LIMIT,
        sort: String = FiatCurrencyService.ID
    ) =
        withContext(Dispatchers.IO) {
            currencyApi.getFiatCurrencyList(limit, sort).toCurrencyList()
        }


    private fun FiatResponseEntity.toCurrencyList() =
        this.data.map { Currency(it.name, it.id) }
}