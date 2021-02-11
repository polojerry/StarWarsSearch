package com.polotech.starwars.search.fakes.repository

import com.polotech.starwars.domain.models.CharacterWithDetailsModel
import com.polotech.starwars.domain.models.FilmModel
import com.polotech.starwars.domain.models.PlanetModel
import com.polotech.starwars.domain.models.SpeciesModel
import com.polotech.starwars.domain.repository.CharacterDetailsRepository
import com.polotech.starwars.search.fakes.DataFake
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class CharacterDetailsRepositoryFake : CharacterDetailsRepository {
    override suspend fun fetchCharacterDetail(characterUrl: String): Flow<CharacterWithDetailsModel> {
        return when {
            characterUrl.contains(DataFake.urls.urlValid) -> {
                flowOf(DataFake.charactersWithDetails.character)
            }
            else -> {
                throw UnsupportedOperationException()
            }
        }
    }

    override suspend fun fetchPlanet(url: String): Flow<PlanetModel> {
        return when {
            url.contains(DataFake.urls.urlValid) -> {
                flowOf(DataFake.planet.planetModel)
            }
            else -> {
                throw UnsupportedOperationException()
            }
        }
    }

    override suspend fun fetchSpecies(url: String): Flow<List<SpeciesModel>> {
        return when {
            url.contains(DataFake.urls.urlValid) -> {
                flowOf(DataFake.lists.listOfSpecie)
            }
            else -> {
                throw UnsupportedOperationException()
            }
        }
    }

    override suspend fun fetchFilms(url: String): Flow<List<FilmModel>> {
        return when {
            url.contains(DataFake.urls.urlValid) -> {
                flowOf(DataFake.lists.listOfFilms)
            }
            else -> {
                throw UnsupportedOperationException()
            }
        }
    }
}