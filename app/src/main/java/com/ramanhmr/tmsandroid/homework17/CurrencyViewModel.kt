package com.ramanhmr.tmsandroid.homework17

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ramanhmr.tmsandroid.homework17.restApi.FiatCurrencyService
import kotlinx.coroutines.launch

class CurrencyViewModel(private val currencyRepository: CurrencyRepository) : ViewModel() {
    val currenciesLiveData: MutableLiveData<List<Currency>> = MutableLiveData()

    init {
        viewModelScope.launch {
            currenciesLiveData.value = currencyRepository.getCurrencies()
        }
    }

    fun getCurrencies(sort: String, limit: Int = FiatCurrencyService.DEFAULT_LIMIT) {
        viewModelScope.launch {
            currenciesLiveData.value = currencyRepository.getCurrencies(limit, sort)
        }
    }
}