package com.polotech.starwars.data.remote.mapper

import com.polotech.starwars.data.remote.models.*
import com.polotech.starwars.domain.models.*

fun CharacterNetwork.toDomain(): CharacterModel {
    return CharacterModel(
        name = this.name,
        height = this.height,
        birthYear = this.birth_year,
        url = this.url

    )
}

fun CharacterWithDetailsNetwork.toDomain(): CharacterWithDetailsModel {
    return CharacterWithDetailsModel(
        name = name,
        height = height,
        birthYear = birthYear,
        url = url,
        filmUrls = filmUrls,
        planetUrl = planetUrl,
        speciesUrls = speciesUrls
    )
}

fun PlanetNetwork.toDomain() : PlanetModel {
    return PlanetModel(
        name = name,
        population = population
    )
}

fun SpeciesNetwork.toDomain() : SpeciesModel{
    return SpeciesModel(
        name = name,
        language = language,
        homeWorld = homeWorld
    )
}

fun FilmNetwork.toDomain() : FilmModel {
    return FilmModel(
        title = title,
        openingCrawl = openingCrawl
    )
}