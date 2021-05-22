package com.ramanhmr.tmsandroid.homework3

abstract class Animal(var speedMS: Double) {
    fun timeOfRoute(): Double {
        return DISTANCE / speedMS / SEC_IN_HOUR
    }

    companion object {
        private const val DISTANCE = 1080
        private const val SEC_IN_HOUR = 3600
    }
}