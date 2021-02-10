package com.polotech.starwars.search.util

import java.math.RoundingMode

internal fun cmToFeetConverter(heightInCm: String): String {
    if (heightInCm == "unknown") return heightInCm
    val heightInFoot =
        (heightInCm.toDouble() * 0.0328084).toBigDecimal().setScale(2, RoundingMode.UP)
    return heightInFoot.toString()
}

internal fun populationConverter(population: String): String {
    if (population.contains("unknown")) return population
    val populationInt = (population).toLong()
    return String.format("%,d", populationInt)
}