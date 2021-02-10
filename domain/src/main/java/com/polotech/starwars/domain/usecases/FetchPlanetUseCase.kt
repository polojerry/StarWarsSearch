package com.polotech.starwars.domain.usecases

import com.polotech.starwars.domain.models.PlanetModel
import com.polotech.starwars.domain.repository.CharacterDetailsRepository
import kotlinx.coroutines.flow.Flow

class FetchPlanetUseCase(private val characterDetailsRepository: CharacterDetailsRepository) :
    BaseUseCase<String, Flow<PlanetModel>> {
    override suspend fun invoke(params: String): Flow<PlanetModel> {
        return characterDetailsRepository.fetchPlanet(params)
    }
}