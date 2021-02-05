package com.polotech.starwars.data.remote.repositories

import com.polotech.starwars.domain.models.CharacterModel
import com.polotech.starwars.domain.repository.SearchCharacterRepository
import kotlinx.coroutines.flow.Flow

class SearchCharacterRepositoryImpl : SearchCharacterRepository {
    override suspend fun searchCharacter(characterName: String): Flow<List<CharacterModel>> {
        TODO("Not yet implemented")
    }
}