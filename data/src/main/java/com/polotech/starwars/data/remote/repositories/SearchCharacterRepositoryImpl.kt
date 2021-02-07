package com.polotech.starwars.data.remote.repositories

import com.polotech.starwars.data.remote.api.StarWarsApiService
import com.polotech.starwars.data.remote.mapper.toDomain
import com.polotech.starwars.domain.models.CharacterModel
import com.polotech.starwars.domain.repository.SearchCharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchCharacterRepositoryImpl (private val startWarsApi : StarWarsApiService): SearchCharacterRepository {
    override suspend fun searchCharacter(characterName: String): Flow<List<CharacterModel>>  = flow{
        val searchResponse = startWarsApi.searchCharacter(characterName)

        emit(searchResponse.results.map { characterNetwork->
            characterNetwork.toDomain()
        })
    }
}