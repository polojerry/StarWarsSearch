package com.polotech.starwars.domain.usecases

import com.polotech.starwars.domain.models.FilmModel
import com.polotech.starwars.domain.repository.CharacterDetailsRepository
import kotlinx.coroutines.flow.Flow

class FetchFilmUseCase(private val characterDetailsRepository: CharacterDetailsRepository) :
    BaseUseCase<List<String>, Flow<List<FilmModel>>> {
    override suspend fun invoke(params: List<String>): Flow<List<FilmModel>> {
        return characterDetailsRepository.fetchFilms(params)
    }

}