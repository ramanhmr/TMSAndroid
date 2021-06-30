package com.ramanhmr.tmsandroid.homework13

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ramanhmr.tmsandroid.homework10.Candy
import com.ramanhmr.tmsandroid.homework10.CandyFactory

class CandyListViewModel : ViewModel() {
    val candiesLiveData: LiveData<List<Candy>> by lazy {
        MutableLiveData(CandyFactory.createCandies(CANDY_AMOUNT))
    }

    companion object {
        private const val CANDY_AMOUNT = 300
    }
}