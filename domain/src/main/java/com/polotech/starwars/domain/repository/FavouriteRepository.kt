package com.polotech.starwars.domain.repository

import com.polotech.starwars.domain.models.CharacterModel
import kotlinx.coroutines.flow.Flow

interface FavouriteRepository {

    suspend fun insertFavourite(characterModel: CharacterModel)

    suspend fun getFavourites(): Flow<List<CharacterModel>>

}