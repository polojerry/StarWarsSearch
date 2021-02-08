package com.polotech.starwars.domain.repository

import com.polotech.starwars.domain.models.CharacterWithDetailsModel
import com.polotech.starwars.domain.models.FilmModel
import com.polotech.starwars.domain.models.PlanetModel
import com.polotech.starwars.domain.models.SpeciesModel
import kotlinx.coroutines.flow.Flow

interface CharacterDetailsRepository {

    fun fetchCharacterDetail(characterUrl: String): Flow<CharacterWithDetailsModel>

    fun fetchPlanet(planetUrl: String): Flow<PlanetModel>

    fun fetchSpecies(speciesUrls: List<String>): Flow<List<SpeciesModel>>

    fun fetchFilms(filmsUrls: List<String>): Flow<List<FilmModel>>
}