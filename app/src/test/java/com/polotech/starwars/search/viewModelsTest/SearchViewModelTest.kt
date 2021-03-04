package com.polotech.starwars.search.viewModelsTest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.polotech.starwars.data.remote.util.ErrorHandlerImpl
import com.polotech.starwars.domain.models.error.ErrorHandler
import com.polotech.starwars.domain.usecases.GetFavouriteUseCase
import com.polotech.starwars.domain.usecases.InsertFavouriteUseCase
import com.polotech.starwars.domain.usecases.SearchCharacterUseCase
import com.polotech.starwars.search.fakes.DataFake
import com.polotech.starwars.search.fakes.repository.FavouriteCharacterRepositoryFake
import com.polotech.starwars.search.fakes.repository.SearchCharacterRepositoryFake
import com.polotech.starwars.search.mappers.toModel
import com.polotech.starwars.search.models.Results
import com.polotech.starwars.search.ui.search.SearchViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class SearchViewModelTest {

    private lateinit var viewModel: SearchViewModel
    private lateinit var errorHandler: ErrorHandler

    private lateinit var insertFavouriteUse : InsertFavouriteUseCase
    @get:Rule
    val instantTaskExecutorRle = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()


    @Before
    fun setUp() {
        val searchCharacter = SearchCharacterRepositoryFake()
        val fakeFavouriteCharacterRepositoryFake = FavouriteCharacterRepositoryFake()

        val searchCharacterUseCase = SearchCharacterUseCase(searchCharacter)
        val getFavouriteUseCase = GetFavouriteUseCase(fakeFavouriteCharacterRepositoryFake)
        insertFavouriteUse = InsertFavouriteUseCase(fakeFavouriteCharacterRepositoryFake)

        errorHandler = ErrorHandlerImpl()
        viewModel = SearchViewModel(searchCharacterUseCase, getFavouriteUseCase, errorHandler)

    }

    @Test
    fun `given a successful response, ResultSuccess should be returned`() {

        testCoroutineRule.runBlockingTest {
            viewModel.searchCharacter(DataFake.search.searchWithValues)
            viewModel.character.observeForever { results ->
                when (results) {
                    is Results.Success -> {
                        Assert.assertNotNull(results.data)
                    }
                    else -> return@observeForever
                }

            }

        }
    }

    @Test
    fun `given a successful response with empty result, Result success with an empty result should be returned`() {
        testCoroutineRule.runBlockingTest {
            viewModel.searchCharacter(DataFake.search.empty_search)
            viewModel.character.observeForever { results ->
                when (results) {
                    is Results.Success -> {
                        Assert.assertSame(results.data.size, 0)
                    }
                    else -> return@observeForever
                }

            }

        }
    }

    @Test
    fun `given a failed response, ResultError with an error should be returned`() {

        testCoroutineRule.runBlockingTest {
            viewModel.searchCharacter(DataFake.search.searchWithError)
            viewModel.character.observeForever { results ->
                when (results) {
                    is Results.Failed -> {
                        Assert.assertNotNull(results.error)
                    }
                    else -> return@observeForever
                }

            }

        }
    }

    @Test
    fun `when getFavouriteCharacter is invoked, list of character should be returned`() = runBlocking {
        val character = DataFake.characters.characterPresenter
        val character1 = DataFake.characters.characterPresenter.copy(url = "http://swapi.dev/api/people/21/")

        insertFavouriteUse.invoke(character.toModel())
        insertFavouriteUse.invoke(character1.toModel())

        viewModel.getFavouriteUseCase().observeForever { favouriteCharacters->
            Assert.assertEquals("Should return list of size 2",2,favouriteCharacters.size)
        }
    }

}