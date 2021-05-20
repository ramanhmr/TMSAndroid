package com.ramanhmr.tmsandroid.homework2

class Car(
    val brand: String,
    val displacement: Double,
    var registration: String?,
    var colour: String = "black"
) {
    fun description(): String {
        return "Car brand - ${brand}, colour - ${colour}. Engine displacement is ${displacement}. Registration plate: ${registration ?: "transit"}."
    }
}