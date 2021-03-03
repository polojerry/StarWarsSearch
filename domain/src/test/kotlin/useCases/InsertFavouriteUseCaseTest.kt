package useCases

import com.polotech.starwars.domain.repository.FavouriteRepository
import com.polotech.starwars.domain.usecases.InsertFavouriteUseCase
import fakeData.DataFake
import fakeRepoitory.FavouriteRepositoryFake
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class InsertFavouriteUseCaseTest {
    private lateinit var favouriteRepository: FavouriteRepository
    private lateinit var insertFavouriteUseCase: InsertFavouriteUseCase

    @Before
    fun setUp() {
        favouriteRepository = FavouriteRepositoryFake()
        insertFavouriteUseCase = InsertFavouriteUseCase(favouriteRepository)
    }

    @Test
    fun `when insertFavouriteUseCase is invoked with a character, the character should be inserted into favourites `() =
        runBlocking {
            val characterModel = DataFake.characters.character
            insertFavouriteUseCase(characterModel)
            val characterFavouriteResult =  favouriteRepository.getFavourites().first()

            Assert.assertEquals("We expect List of character with size 1", 1, characterFavouriteResult.size)

        }
}