package repository

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.polotech.starwars.data.localsource.database.FavouriteDao
import com.polotech.starwars.data.localsource.database.StarWarsSearchDatabase
import com.polotech.starwars.data.localsource.mapper.toEntity
import fakes.DataFake
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/*@RunWith(AndroidJUnit::class)*/
class FavouriteRepositoryImpTest {

    private lateinit var starWarsDatabase: StarWarsSearchDatabase
    private lateinit var favouriteDao: FavouriteDao

    @Before
    fun setUp() {
        starWarsDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            StarWarsSearchDatabase::class.java,
        ).build()

        favouriteDao = starWarsDatabase.favouriteDao
    }

    @Test
    fun `when insertFavourite is invoked in dao, the character should be added to favourites`() =
        runBlocking {
            val character = DataFake.characters.characterModel.toEntity()
            favouriteDao.insertFavourite(character)

            val charactersFromDb = favouriteDao.getFavourites()
            Assert.assertEquals("A list of size 1 should be returned", 1, charactersFromDb.size)

        }

    @After
    fun tearDown() {
        starWarsDatabase.close()
    }
}