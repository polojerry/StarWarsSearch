package com.polotech.starwars.data.localsource.repository

import com.polotech.starwars.data.localsource.database.FavouriteDao
import com.polotech.starwars.data.localsource.mapper.toDomain
import com.polotech.starwars.data.localsource.mapper.toEntity
import com.polotech.starwars.domain.models.CharacterModel
import com.polotech.starwars.domain.repository.FavouriteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class FavouriteRepositoryImp(private val favouriteDao: FavouriteDao) : FavouriteRepository {
    override suspend fun insertFavourite(characterModel: CharacterModel) {
        favouriteDao.insertFavourite(characterModel.toEntity())
    }

    override suspend fun getFavourites(): Flow<List<CharacterModel>> = flow {
        val favourites = favouriteDao.getFavourites()
        val favouritesList = mutableListOf<CharacterModel>()

        favourites.forEach { characterEntity ->
            favouritesList.add(characterEntity.toDomain())
        }

        emit(favouritesList)

    }
}