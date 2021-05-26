package com.ramanhmr.tmsandroid.homework4

import android.util.Log

class Worker(name: String, wage: Int) : Employee(name, wage) {
    fun work(tag: String) {
        Log.i(tag, "$name работает.")
    }
}