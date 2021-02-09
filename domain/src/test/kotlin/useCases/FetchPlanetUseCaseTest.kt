package useCases

import com.polotech.starwars.domain.usecases.FetchCharacterWithDetailsUseCase
import com.polotech.starwars.domain.usecases.FetchPlanetUseCase
import fakeRepoitory.CharacterDetailsRepositoryFake
import fakeRepoitory.DataFake
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Test

@ExperimentalCoroutinesApi
class FetchPlanetUseCaseTest {

    private val characterDetailsRepository = CharacterDetailsRepositoryFake()
    private val fetchPlanetUseCase = FetchPlanetUseCase(characterDetailsRepository)

    @Test
    fun `when fetchPlanetUseCase is called, it should return planetModel Object` (){
        runBlockingTest {
            val planet = fetchPlanetUseCase(DataFake.charactersWithDetails.character.planetUrl).first()
            assertNotNull(planet)
        }
    }

    @Test
    fun `when fetchPlanetUseCase is called, it should return the correct planetModel object`(){
        runBlockingTest {
            val planet = fetchPlanetUseCase(DataFake.charactersWithDetails.character.planetUrl).first()

            assertEquals(planet.name, DataFake.planet.planet.name)
            assertEquals(planet.population, DataFake.planet.planet.population)

        }
    }

}