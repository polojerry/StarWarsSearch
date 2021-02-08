package com.polotech.starwars.domain.usecases

import com.polotech.starwars.domain.models.SpeciesModel
import com.polotech.starwars.domain.repository.CharacterDetailsRepository
import kotlinx.coroutines.flow.Flow

class FetchSpeciesUseCase (private val characterDetailsRepository: CharacterDetailsRepository) : BaseUseCase<String, Flow<List<SpeciesModel>>> {
    override suspend fun invoke(params: String): Flow<List<SpeciesModel>> {
        return characterDetailsRepository.fetchSpecies(params)
    }

}