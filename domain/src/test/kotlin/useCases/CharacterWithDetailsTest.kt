package useCases

import com.polotech.starwars.domain.usecases.FetchCharacterWithDetailsUseCase
import fakeRepoitory.CharacterDetailsRepositoryFake
import fakeRepoitory.DataFake
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class CharacterWithDetailsTest {

    private lateinit var characterWithDetailsUseCase: FetchCharacterWithDetailsUseCase

    @Before
    fun setUp() {
        val characterDetailsRepository = CharacterDetailsRepositoryFake()
        characterWithDetailsUseCase = FetchCharacterWithDetailsUseCase(characterDetailsRepository)
    }

    @Test
    fun `when characterWithDetailsUseCase is called, it should return characterWthDetails Object`() {
        runBlockingTest {
            val characterWithDetails =
                characterWithDetailsUseCase(DataFake.charactersWithDetails.character.url).first()
            assertNotNull(characterWithDetails)
        }
    }

    @Test
    fun `when characterWithDetailsUSeCase is called, it should return the correct characterWthDetails object`() {
        runBlockingTest {
            val characterWithDetails =
                characterWithDetailsUseCase(DataFake.charactersWithDetails.character.url)

            val character = characterWithDetails.first()
            assertEquals(character.name, DataFake.charactersWithDetails.character.name)
            assertEquals(character.height, DataFake.charactersWithDetails.character.height)
            assertEquals(character.birthYear, DataFake.charactersWithDetails.character.birthYear)
            assertEquals(character.url, DataFake.charactersWithDetails.character.url)
            assertEquals(character.filmUrls, DataFake.charactersWithDetails.character.filmUrls)
            assertEquals(character.planetUrl, DataFake.charactersWithDetails.character.planetUrl)
            assertEquals(character.speciesUrls,
                DataFake.charactersWithDetails.character.speciesUrls)

        }
    }

}