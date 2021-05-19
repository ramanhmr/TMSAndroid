package com.ramanhmr.tmsandroid.homework2

class Car(
    brand: String,
    displacement: Double,
    var registration: String?,
    var colour: String = "black"
) {
    var brand: String = brand
        private set
    var displacement = displacement
        private set

    fun description(): String {
        return "Brand: ${brand},\nColour: ${colour},\nEngine displacement: ${displacement},\nRegistration plate:" +
                (registration ?: "transit") + "."
    }

}