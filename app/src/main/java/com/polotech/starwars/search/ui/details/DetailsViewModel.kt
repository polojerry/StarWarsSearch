package com.polotech.starwars.search.ui.details

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.polotech.starwars.domain.usecases.*
import com.polotech.starwars.search.di.UseCaseModule
import com.polotech.starwars.search.extensions.doOnError
import com.polotech.starwars.search.mappers.toPresentation
import com.polotech.starwars.search.models.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailsViewModel @ViewModelInject @Inject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle,
    @UseCaseModule.CharacterDetailsUseCase private val characterDetailsUseCase: FetchCharacterWithDetailsUseCase,
    @UseCaseModule.FilmUseCase private val filmUseCase : FetchFilmUseCase,
    @UseCaseModule.PlanetUseCase private val planetUseCase : FetchPlanetUseCase,
    @UseCaseModule.SpeciesUseCase private val specieUseCase : FetchSpeciesUseCase,


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


    init {
        _character.value = savedStateHandle.get<CharacterPresenter>("character")
    }
}