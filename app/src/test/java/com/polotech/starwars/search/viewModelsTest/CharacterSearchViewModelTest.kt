package com.polotech.starwars.search.viewModelsTest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.SavedStateHandle
import com.polotech.starwars.data.remote.util.ErrorHandlerImpl
import com.polotech.starwars.domain.models.error.ErrorHandler
import com.polotech.starwars.domain.repository.FavouriteRepository
import com.polotech.starwars.domain.usecases.FetchFilmUseCase
import com.polotech.starwars.domain.usecases.FetchPlanetUseCase
import com.polotech.starwars.domain.usecases.FetchSpeciesUseCase
import com.polotech.starwars.domain.usecases.InsertFavouriteUseCase
import com.polotech.starwars.search.fakes.DataFake
import com.polotech.starwars.search.fakes.repository.CharacterDetailsRepositoryFake
import com.polotech.starwars.search.fakes.repository.FavouriteCharacterRepositoryFake
import com.polotech.starwars.search.models.Results
import com.polotech.starwars.search.ui.details.DetailsViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class CharacterSearchViewModelTest {

    private lateinit var viewModel: DetailsViewModel
    private lateinit var errorHandler: ErrorHandler

    private lateinit var favouriteRepository : FavouriteRepository

    @get:Rule
    val instantTaskExecutorRle = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()


    @Before
    fun setUp() {
        val saveStateHandle = SavedStateHandle().apply {
            set("character", DataFake.characterWithUrl.characterWithValidUrl)
        }
        val characterDetailsRepository = CharacterDetailsRepositoryFake()
        val filmUseCase = FetchFilmUseCase(characterDetailsRepository)
        val planetUseCase = FetchPlanetUseCase(characterDetailsRepository)
        val specieUseCase = FetchSpeciesUseCase(characterDetailsRepository)

        favouriteRepository = FavouriteCharacterRepositoryFake()
        val insertFavouriteUseCase = InsertFavouriteUseCase(favouriteRepository)


        errorHandler = ErrorHandlerImpl()
        viewModel = DetailsViewModel(
            saveStateHandle,
            filmUseCase,
            planetUseCase,
            specieUseCase,
            insertFavouriteUseCase,
            errorHandler,
        )
    }

    @Test
    fun `given a valid character url, a planet should be returned in the Result Success`(){
        testCoroutineRule.runBlockingTest {
            viewModel.characterPlanet.observeForever{results->
                when(results){
                    is Results.Success ->{
                        Assert.assertNotNull(results.data)
                    }
                    else -> return@observeForever
                }

            }
        }
    }

    @Test
    fun `given a valid character url, a specie should be returned in the Result Success`(){
        testCoroutineRule.runBlockingTest {
            viewModel.characterSpecies.observeForever{results->
                when(results){
                    is Results.Success ->{
                        Assert.assertNotNull(results.data)
                    }
                    else -> return@observeForever
                }

            }
        }
    }

    @Test
    fun `given a valid character url, a film should be returned in the Result Success`(){
        testCoroutineRule.runBlockingTest {
            viewModel.characterFilms.observeForever{results->
                when(results){
                    is Results.Success ->{
                        Assert.assertNotNull(results.data)
                    }
                    else -> return@observeForever
                }

            }

        }
    }

    @Test
    fun `when insertFavouriteUseCase is invoked, the character should be inserted into the db` () = runBlocking {
        val character = DataFake.characters.characterPresenter
        viewModel.insertFavourite(character)

        Assert.assertEquals("Should return list of size 1",1, favouriteRepository.getFavourites().first().size)

    }

}