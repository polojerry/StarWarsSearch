package com.polotech.starwars.domain.repository

import com.polotech.starwars.domain.models.CharacterWithDetailsModel
import com.polotech.starwars.domain.models.FilmModel
import com.polotech.starwars.domain.models.PlanetModel
import com.polotech.starwars.domain.models.SpeciesModel
import kotlinx.coroutines.flow.Flow

interface CharacterDetailsRepository {

    suspend fun fetchCharacterDetail(characterUrl: String): Flow<CharacterWithDetailsModel>

    suspend  fun fetchPlanet(url: String): Flow<PlanetModel>

    suspend fun fetchSpecies(url: String): Flow<List<SpeciesModel>>

    suspend fun fetchFilms(url: String): Flow<List<FilmModel>>
}