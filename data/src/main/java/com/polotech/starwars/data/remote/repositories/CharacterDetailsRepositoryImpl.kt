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

    override suspend fun fetchPlanet(url: String): Flow<PlanetModel> = flow {
        val characterDetails = starWarsApiService.fetchCharacterDetails(url)
        val planet = starWarsApiService.fetchPlanet(characterDetails.planetUrl)
        emit(planet.toDomain())
    }

    override suspend fun fetchSpecies(url: String): Flow<List<SpeciesModel>> = flow {
        val characterDetails = starWarsApiService.fetchCharacterDetails(url)
        val species = mutableListOf<SpeciesModel>()
        characterDetails.speciesUrls.forEach {
            val specie = starWarsApiService.fetchSpecie(it)
            species.add(specie.toDomain())
        }
    }

    override suspend fun fetchFilms(url: String): Flow<List<FilmModel>> = flow {
        val characterDetails = starWarsApiService.fetchCharacterDetails(url)
        val films = mutableListOf<FilmModel>()
        characterDetails.filmUrls.forEach {
            val film = starWarsApiService.fetchFilm(it)
            films.add(film.toDomain())
        }
    }
}