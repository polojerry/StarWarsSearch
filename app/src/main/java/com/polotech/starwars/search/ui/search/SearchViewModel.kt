package com.polotech.starwars.search.ui.search

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.polotech.starwars.domain.models.error.ErrorHandler
import com.polotech.starwars.domain.usecases.SearchCharacterUseCase
import com.polotech.starwars.search.di.UseCaseModule
import com.polotech.starwars.search.extensions.doOnError
import com.polotech.starwars.search.mappers.toPresentation
import com.polotech.starwars.search.models.CharacterPresenter
import com.polotech.starwars.search.models.Results
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchViewModel @ViewModelInject @Inject constructor(
    @UseCaseModule.SearchUseCase private val searchCharacterUseCase: SearchCharacterUseCase,
    private val errorHandler: ErrorHandler,
) :
    ViewModel() {

    private val _characters = MutableLiveData<Results<List<CharacterPresenter>>>()
    val character: LiveData<Results<List<CharacterPresenter>>>
        get() = _characters

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        _characters.postValue(Results.failed(errorHandler.getError(throwable)))
    }

    fun searchCharacter(characterName: String) {
        _characters.value = Results.loading()

        viewModelScope.launch(coroutineExceptionHandler) {
            searchCharacterUseCase(characterName)
                .doOnError {
                    _characters.postValue(Results.failed(errorHandler.getError(it)))
                }
                .collect { characterList ->
                    val characters = characterList.map {
                        it.toPresentation()
                    }
                    _characters.postValue(Results.success(characters))
                }
        }
    }

}


