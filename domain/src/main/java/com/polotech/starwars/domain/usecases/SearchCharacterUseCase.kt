package com.polotech.starwars.domain.usecases

import com.polotech.starwars.domain.models.CharacterModel
import com.polotech.starwars.domain.repository.SearchCharacterRepository
import kotlinx.coroutines.flow.Flow

class SearchCharacterUseCase(private val searchCharacterRepository: SearchCharacterRepository) :
    BaseUseCase<String, Flow<List<CharacterModel>>> {
    override suspend fun invoke(params: String): Flow<List<CharacterModel>> {
        return searchCharacterRepository.searchCharacter(params)
    }
}