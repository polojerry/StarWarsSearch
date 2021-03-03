package useCases

import com.polotech.starwars.domain.usecases.FetchSpeciesUseCase
import fakeRepoitory.CharacterDetailsRepositoryFake
import fakeData.DataFake
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class FetchSpeciesUseCaseTest {

    private lateinit var fetchSpeciesUseCase: FetchSpeciesUseCase

    @Before
    fun setUp() {
        val characterDetailsRepository = CharacterDetailsRepositoryFake()
        fetchSpeciesUseCase = FetchSpeciesUseCase(characterDetailsRepository)
    }

    @Test
    fun `when fetchSpeciesUseCase is called, it should return specieModel Object`() {
        runBlockingTest {
            val specie =
                fetchSpeciesUseCase(DataFake.charactersWithDetails.character.speciesUrls[0]).first()
            assertNotNull(specie)
        }
    }

    @Test
    fun `when fetchSpeciesUseCase is called, it should return the correct list of specieModel object`() {
        runBlockingTest {
            val species =
                fetchSpeciesUseCase(DataFake.charactersWithDetails.character.speciesUrls[0]).first()

            val specie = species.first()
            assertEquals(specie.name, DataFake.specie.specie.name)
            assertEquals(specie.language, DataFake.specie.specie.language)
            assertEquals(specie.homeWorld, DataFake.specie.specie.homeWorld)

        }
    }

}