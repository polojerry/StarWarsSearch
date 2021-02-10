package com.polotech.starwars.search.mappers

import com.polotech.starwars.domain.models.*
import com.polotech.starwars.search.models.*
import com.polotech.starwars.search.util.cmToFeetConverter
import com.polotech.starwars.search.util.populationConverter

fun CharacterModel.toPresentation(): CharacterPresenter {
    return CharacterPresenter(
        name = name,
        heightInCm = height,
        heightInFeet = cmToFeetConverter(height),
        birthYear = birthYear,
        url = url,
    )
}

fun PlanetModel.toPresentation(): PlanetPresenter {
    return PlanetPresenter(
        name = name,
        population = populationConverter(population)
    )
}

fun SpeciesModel.toPresentation(): SpeciesPresenter {
    return SpeciesPresenter(
        name = name,
        language = language,
        homeWorld = homeWorld
    )
}

fun FilmModel.toPresentation(): FilmPresenter {
    return FilmPresenter(
        title = title,
        openingCrawl = openingCrawl
    )
}