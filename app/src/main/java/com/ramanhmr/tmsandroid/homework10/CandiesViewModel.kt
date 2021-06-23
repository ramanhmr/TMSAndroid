package com.ramanhmr.tmsandroid.homework10

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CandiesViewModel : ViewModel() {
    val candyListLiveData: LiveData<List<Candy>> by lazy {
        MutableLiveData(CandyFactory.createCandies(CANDIES_AMOUNT))
    }

    companion object {
        private const val CANDIES_AMOUNT = 300
    }
}