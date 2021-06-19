package com.ramanhmr.tmsandroid.homework10

import java.util.*

object CandyMaker {
    fun createCandies(amount: Int): List<Candy> {
        val candies = mutableListOf<Candy>()
        for (i in 1..amount) {
            when (i) {
                in 1..amount/3 -> candies.add(newCandy("Roshen"))
                in amount/3..amount/3*2 -> candies.add(newCandy("Kamunarka"))
                else -> candies.add(newCandy("Spartak"))
            }
        }
        return candies
    }

    fun newCandy(brand: String) = Candy(brand, Random().nextInt(99999999)+1)
}