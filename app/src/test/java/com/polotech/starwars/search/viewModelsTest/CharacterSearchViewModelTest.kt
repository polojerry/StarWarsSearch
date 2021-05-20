package com.polotech.starwars.search.viewModelsTest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.SavedStateHandle
import com.polotech.starwars.data.remote.util.ErrorHandlerImpl
import com.polotech.starwars.domain.models.error.ErrorHandler
import com.polotech.starwars.domain.usecases.FetchFilmUseCase
import com.polotech.starwars.domain.usecases.FetchPlanetUseCase
import com.polotech.starwars.domain.usecases.FetchSpeciesUseCase
import com.polotech.starwars.search.fakes.DataFake
import com.polotech.starwars.search.fakes.repository.CharacterDetailsRepositoryFake
import com.polotech.starwars.search.models.Results
import com.polotech.starwars.feature.details.ui.details.DetailsViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class CharacterSearchViewModelTest {

    private lateinit var viewModel: com.polotech.starwars.feature.details.ui.details.DetailsViewModel
    private lateinit var errorHandler: ErrorHandler

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


        errorHandler = ErrorHandlerImpl()
        viewModel = com.polotech.starwars.feature.details.ui.details.DetailsViewModel(
            saveStateHandle,
            filmUseCase,
            planetUseCase,
            specieUseCase,
            errorHandler
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

}