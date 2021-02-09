package fakeRepoitory

import com.polotech.starwars.domain.models.CharacterWithDetailsModel
import com.polotech.starwars.domain.models.FilmModel
import com.polotech.starwars.domain.models.PlanetModel
import com.polotech.starwars.domain.models.SpeciesModel
import com.polotech.starwars.domain.repository.CharacterDetailsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf


class CharacterDetailsRepositoryFake : CharacterDetailsRepository {
    override suspend fun fetchCharacterDetail(characterUrl: String): Flow<CharacterWithDetailsModel> {
        val characterWithDetails = DataFake.charactersWithDetails.character
        return flowOf(characterWithDetails)
    }

    override suspend fun fetchPlanet(url: String): Flow<PlanetModel> {
        val planet = DataFake.planet.planet
        return flowOf(planet)
    }

    override suspend fun fetchSpecies(url: String): Flow<List<SpeciesModel>> {
        val species = listOf(
            DataFake.specie.specie,
            DataFake.specie.specie1,
        )

        return flowOf(species)
    }

    override suspend fun fetchFilms(url: String): Flow<List<FilmModel>> {
        val films = listOf(
            DataFake.films.film,
            DataFake.films.film1
        )

        return flowOf(films)
    }
}