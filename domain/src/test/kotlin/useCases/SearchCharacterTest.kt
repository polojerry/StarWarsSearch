package useCases

import com.polotech.starwars.domain.models.CharacterModel
import com.polotech.starwars.domain.usecases.SearchCharacterUseCase
import fakeRepoitory.DataFake
import fakeRepoitory.SearchCharacterRepositoryFake
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class SearchCharacterTest {

    private lateinit var searchCharacterUseCase: SearchCharacterUseCase

    @Before
    fun setUp() {
        val searchRepository = SearchCharacterRepositoryFake()
        searchCharacterUseCase = SearchCharacterUseCase(searchRepository)
    }

    @Test
    fun `when searchCharacterUseCase is called, it should return list of characters`() {
        runBlockingTest {
            val characters: List<CharacterModel> = searchCharacterUseCase("").first()
            assertEquals(2, characters.size)
        }
    }

    @Test
    fun `when searchCharacterUseCase is called, it should return the correct list of characters`() {
        runBlockingTest {
            val characters: List<CharacterModel> = searchCharacterUseCase("").first()
            val character = characters[0]
            val character1 = characters[1]

            assertEquals(character.name, DataFake.characters.character.name)
            assertEquals(character.height, DataFake.characters.character.height)
            assertEquals(character.birthYear, DataFake.characters.character.birthYear)
            assertEquals(character.url, DataFake.characters.character.url)

            assertEquals(character1.name, DataFake.characters.character1.name)
            assertEquals(character1.height, DataFake.characters.character1.height)
            assertEquals(character1.birthYear, DataFake.characters.character1.birthYear)
            assertEquals(character1.url, DataFake.characters.character1.url)

        }
    }


}