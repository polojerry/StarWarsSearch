package com.polotech.starwars.domain.usecases

import com.polotech.starwars.domain.models.CharacterModel
import com.polotech.starwars.domain.repository.FavouriteRepository

class InsertFavouriteUseCase(private val favouriteRepository: FavouriteRepository) : BaseUseCase<CharacterModel, Unit> {
    override suspend fun invoke(params: CharacterModel) {
        favouriteRepository.insertFavourite(params)
    }
}