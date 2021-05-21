package com.polotech.starwars.feature.details.ui.details

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.polotech.starwars.domain.models.error.ErrorHandler
import com.polotech.starwars.domain.models.error.ErrorModel
import com.polotech.starwars.domain.usecases.FetchFilmUseCase
import com.polotech.starwars.domain.usecases.FetchPlanetUseCase
import com.polotech.starwars.domain.usecases.FetchSpeciesUseCase
import com.polotech.starwars.core.di.UseCaseModule
import com.polotech.starwars.feature.details.mappers.toPresentation
import com.polotech.starwars.feature.details.models.*
import com.polotech.starwars.search.common.extensions.doOnError
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailsViewModel @ViewModelInject @Inject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle,
    @UseCaseModule.FilmUseCase private val filmUseCase: FetchFilmUseCase,
    @UseCaseModule.PlanetUseCase private val planetUseCase: FetchPlanetUseCase,
    @UseCaseModule.SpeciesUseCase private val specieUseCase: FetchSpeciesUseCase,
    private val errorHandler: ErrorHandler,

    ) : ViewModel() {

    private val _character = MutableLiveData<CharacterPresenter>()
    val character: LiveData<CharacterPresenter>
        get() = _character

    private val _charactersPlanet = MutableLiveData<Results<PlanetPresenter>>()
    val characterPlanet: LiveData<Results<PlanetPresenter>>
        get() = _charactersPlanet

    private val _charactersSpecies = MutableLiveData<Results<List<SpeciesPresenter>>>()
    val characterSpecies: LiveData<Results<List<SpeciesPresenter>>>
        get() = _charactersSpecies

    private val _charactersFilms = MutableLiveData<Results<List<FilmPresenter>>>()
    val characterFilms: LiveData<Results<List<FilmPresenter>>>
        get() = _charactersFilms

    private val _generalError = MutableLiveData<ErrorModel>()
    val generalError: LiveData<ErrorModel>
        get() = _generalError


    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        _generalError.postValue((errorHandler.getError(throwable)))
    }

    init {
       // _character.value = savedStateHandle.get<CharacterPresenter>("character")
        val characterUrl = savedStateHandle.get<String>("character")
        fetchPlanet(characterUrl)
        fetchFilms(characterUrl)
        fetchSpecies(characterUrl)
    }

    private fun fetchPlanet(url: String?) {
        _charactersPlanet.value = Results.loading()
        url?.let {
            viewModelScope.launch(coroutineExceptionHandler) {
                planetUseCase(it)
                    .doOnError {
                        _charactersPlanet.value = Results.failed(errorHandler.getError(it))
                    }.collect {
                        _charactersPlanet.value = Results.success(it.toPresentation())
                    }
            }
        }
    }

    private fun fetchSpecies(url: String?) {
        _charactersSpecies.value = Results.loading()
        url?.let {
            viewModelScope.launch(coroutineExceptionHandler) {
                specieUseCase(it)
                    .doOnError {
                        _charactersSpecies.value = Results.failed(errorHandler.getError(it))
                    }.collect {
                        _charactersSpecies.value = Results.success(
                            it.map { specie ->
                                specie.toPresentation()
                            }
                        )
                    }
            }
        }
    }

    private fun fetchFilms(url: String?) {
        _charactersFilms.value = Results.loading()
        url?.let {
            viewModelScope.launch(coroutineExceptionHandler) {
                filmUseCase(it)
                    .doOnError {
                        _charactersFilms.value = Results.failed(errorHandler.getError(it))
                    }.collect {
                        _charactersFilms.value = Results.success(
                            it.map { film ->
                                film.toPresentation()
                            }
                        )
                    }
            }
        }
    }

}