package com.ramanhmr.tmsandroid.homework10

import java.util.*

object CandyFactory {
    fun createCandies(amount: Int): List<Candy> {
        val candies = mutableListOf<Candy>()
        for (i in 1..amount) {
            when (i) {
                in 1..amount / 3 -> candies.add(makeCandy(CandyBrands.ROSHEN))
                in amount / 3..amount / 3 * 2 -> candies.add(makeCandy(CandyBrands.KOMMUNARKA))
                else -> candies.add(makeCandy(CandyBrands.SPARTAK))
            }
        }
        return candies
    }

    private fun makeCandy(brand: CandyBrands) =
        Candy(brand.brandName, Random().nextInt(99999999) + 1, brand.imageURL)
}