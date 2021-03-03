package useCases

import com.polotech.starwars.domain.usecases.FetchFilmUseCase
import fakeRepoitory.CharacterDetailsRepositoryFake
import fakeData.DataFake
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class FetchFilmUseCaseTest {

    private lateinit var fetchFilmsUseCase : FetchFilmUseCase

    @Before
    fun setUp() {
        val characterDetailsRepository = CharacterDetailsRepositoryFake()
        fetchFilmsUseCase = FetchFilmUseCase(characterDetailsRepository)
    }

    @Test
    fun `when fetchFilmsUseCase is called, it should return a list of Films`() {
        runBlockingTest {
            val films =
                fetchFilmsUseCase(DataFake.charactersWithDetails.character.filmUrls[0]).first()
            Assert.assertEquals(2, films.size)
        }
    }

    @Test
    fun `when fetchFilmsUseCase is called, it should return the correct it should return the correct list of Films`() {
        runBlockingTest {
            val films =
                fetchFilmsUseCase(DataFake.charactersWithDetails.character.filmUrls[0]).first()

            val film = films[0]
            val film1 = films[1]

            Assert.assertEquals(film.title, DataFake.films.film.title)
            Assert.assertEquals(film.openingCrawl, DataFake.films.film.openingCrawl)

            Assert.assertEquals(film1.title, DataFake.films.film1.title)
            Assert.assertEquals(film1.openingCrawl, DataFake.films.film1.openingCrawl)

        }
    }
}