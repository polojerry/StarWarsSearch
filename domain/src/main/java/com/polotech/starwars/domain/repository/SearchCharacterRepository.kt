package com.polotech.starwars.domain.repository

import com.polotech.starwars.domain.models.CharacterModel
import kotlinx.coroutines.flow.Flow

interface SearchCharacterRepository {
    suspend fun searchCharacter(characterName: String): Flow<List<CharacterModel>>
}