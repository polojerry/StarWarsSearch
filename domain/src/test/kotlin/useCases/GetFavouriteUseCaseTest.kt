package useCases

import com.polotech.starwars.domain.repository.FavouriteRepository
import com.polotech.starwars.domain.usecases.GetFavouriteUseCase
import fakeData.DataFake
import fakeRepoitory.FavouriteRepositoryFake
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class GetFavouriteUseCaseTest {

    private lateinit var favouriteRepository: FavouriteRepository
    private lateinit var getFavouritesUseCase: GetFavouriteUseCase

    @Before
    fun setUp() {
        favouriteRepository = FavouriteRepositoryFake()
        getFavouritesUseCase = GetFavouriteUseCase(favouriteRepository)
    }

    @Test
    fun `when getFavouritesUseCase is invokes, list of favourites should be returned `() =
        runBlocking {
            val characters = DataFake.characters.character
            favouriteRepository.insertFavourite(characters)

            val favouriteCharacters = getFavouritesUseCase(null).first()
            Assert.assertEquals(
                "List of Characters should be returned",
                1,
                favouriteCharacters.size
            )
        }

}