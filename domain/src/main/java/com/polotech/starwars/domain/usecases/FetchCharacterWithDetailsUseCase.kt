package com.polotech.starwars.domain.usecases

import com.polotech.starwars.domain.models.CharacterWithDetailsModel
import com.polotech.starwars.domain.repository.CharacterDetailsRepository
import kotlinx.coroutines.flow.Flow

class FetchCharacterWithDetailsUseCase(private val characterDetailsRepository: CharacterDetailsRepository) :
    BaseUseCase<String, Flow<CharacterWithDetailsModel>> {
    override suspend fun invoke(params: String): Flow<CharacterWithDetailsModel> {
        return characterDetailsRepository.fetchCharacterDetail(params)
    }
}