package com.polotech.starwars.search.mappers

import com.polotech.starwars.data.remote.models.CharacterWithDetailsNetwork
import com.polotech.starwars.data.remote.models.FilmNetwork
import com.polotech.starwars.data.remote.models.PlanetNetwork
import com.polotech.starwars.data.remote.models.SpeciesNetwork
import com.polotech.starwars.domain.models.*
import com.polotech.starwars.search.models.*
import com.polotech.starwars.search.util.cmToFeetConverter

fun CharacterModel.toPresentation(): CharacterPresenter {
    return CharacterPresenter(
        name = name,
        heightInCm = height,
        heightInFeet = cmToFeetConverter(height),
        birthYear = birthYear,
        url = url,
    )
}


fun CharacterWithDetailsModel.toPresentation(): CharacterWithDetailsPresenter {
    return CharacterWithDetailsPresenter(
        name = name,
        height = height,
        birthYear = birthYear,
        url = url,
        filmUrls = filmUrls,
        planetUrl = planetUrl,
        speciesUrls = speciesUrls
    )
}

fun PlanetModel.toPresentation() : PlanetPresenter {
    return PlanetPresenter(
        name = name,
        population = population
    )
}

fun SpeciesModel.toPresentation() : SpeciesPresenter {
    return SpeciesPresenter(
        name = name,
        language = language,
        homeWorld = homeWorld
    )
}

fun FilmModel.toPresentation() : FilmPresenter {
    return FilmPresenter(
        title = title,
        openingCrawl = openingCrawl
    )
}