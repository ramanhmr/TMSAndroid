package com.ramanhmr.tmsandroid.homework2

object LocalGarage {
    private fun getCars(): List<Car> {
        return listOf<Car>(
            Car("Honda", 1.7, "HM-5345", "green"),
            Car("BMW", 2.2, null),
            Car("Skoda", 1.8, "KM-9895", "silver"),
            Car("Toyota", 2.0, null, "white"),
            Car("Skoda", 2.1, "KO-7633"),
            Car("Ford", 2.0, "OM-1157", "black")
        )
    }

    fun describeCars() {
        println(getCars().iterator().forEach { car -> car.description() })
    }
}