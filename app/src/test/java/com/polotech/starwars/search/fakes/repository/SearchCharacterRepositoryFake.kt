package com.polotech.starwars.search.fakes.repository

import com.polotech.starwars.domain.models.CharacterModel
import com.polotech.starwars.domain.repository.SearchCharacterRepository
import com.polotech.starwars.search.fakes.DataFake
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class SearchCharacterRepositoryFake : SearchCharacterRepository {
    override suspend fun searchCharacter(characterName: String): Flow<List<CharacterModel>> {
        return when {
            characterName.contains(DataFake.search.empty_search) -> {
                flowOf(emptyList())
            }
            characterName.contains(DataFake.search.searchWithValues) -> {
                flowOf(DataFake.lists.listOfCharacters)
            }
            else -> {
                throw UnsupportedOperationException()
            }
        }

    }
}