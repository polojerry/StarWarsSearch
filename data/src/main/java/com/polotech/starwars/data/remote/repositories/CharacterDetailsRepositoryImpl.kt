package com.polotech.starwars.data.remote.repositories

import com.polotech.starwars.data.remote.api.StarWarsApiService
import com.polotech.starwars.data.remote.mapper.toDomain
import com.polotech.starwars.domain.models.CharacterWithDetailsModel
import com.polotech.starwars.domain.models.FilmModel
import com.polotech.starwars.domain.models.PlanetModel
import com.polotech.starwars.domain.models.SpeciesModel
import com.polotech.starwars.domain.repository.CharacterDetailsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CharacterDetailsRepositoryImpl(private val starWarsApiService: StarWarsApiService) :
    CharacterDetailsRepository {

    override suspend fun fetchCharacterDetail(characterUrl: String): Flow<CharacterWithDetailsModel> =
        flow {
            val characterDetail = starWarsApiService.fetchCharacterDetails(characterUrl)
            emit(characterDetail.toDomain())
        }

    override suspend fun fetchPlanet(planetUrl: String): Flow<PlanetModel> = flow {
        val planet = starWarsApiService.fetchPlanet(planetUrl)
        emit(planet.toDomain())
    }

    override suspend fun fetchSpecies(speciesUrls: List<String>): Flow<List<SpeciesModel>> = flow {
        val species = mutableListOf<SpeciesModel>()
        speciesUrls.forEach {
            val specie = starWarsApiService.fetchSpecie(it)
            species.add(specie.toDomain())
        }
        emit(species)
    }

    override suspend fun fetchFilms(filmsUrls: List<String>): Flow<List<FilmModel>> = flow {
        val films = mutableListOf<FilmModel>()
        filmsUrls.forEach {
            val film = starWarsApiService.fetchFilm(it)
            films.add(film.toDomain())
        }
        emit(films)
    }
}