package com.polotech.starwars.search

import com.polotech.starwars.search.fakes.DataFake
import com.polotech.starwars.search.fakes.DataFake.population
import com.polotech.starwars.search.util.cmToFeetConverter
import com.polotech.starwars.search.util.populationConverter
import org.junit.Assert
import org.junit.Test

class ConvertersTest {

    @Test
    fun `when height string in cm is passed, a height in feet should be returned`(){
        val heightInFeet = cmToFeetConverter(DataFake.height.cm)

        Assert.assertEquals(heightInFeet, DataFake.height.feet)
    }

    @Test
    fun `when unknown population is passed, unknown should be returned`(){
        val unknown = populationConverter(population.unknown)
        Assert.assertEquals(unknown, population.unknown)
    }

    @Test
    fun `when a string of population is passed, a string formatted representation of population should be returned`(){
        val population = populationConverter(population.populationUnformated)
        Assert.assertEquals(population, DataFake.population.populationUnformated)
    }
}