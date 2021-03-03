package com.polotech.starwars.domain.usecases

import com.polotech.starwars.domain.models.CharacterModel
import com.polotech.starwars.domain.repository.FavouriteRepository
import kotlinx.coroutines.flow.Flow

class GetFavouriteUseCase(private val favouriteRepository: FavouriteRepository) : BaseUseCase<Unit?, Flow<List<CharacterModel>>>{
    override suspend fun invoke(params: Unit?): Flow<List<CharacterModel>> {
        return favouriteRepository.getFavourites()
    }
}