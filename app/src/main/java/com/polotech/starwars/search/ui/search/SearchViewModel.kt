package com.polotech.starwars.search.ui.search

import android.util.Log
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.polotech.starwars.domain.usecases.SearchCharacterUseCase
import com.polotech.starwars.search.di.UseCaseModule
import com.polotech.starwars.search.mappers.toPresentation
import com.polotech.starwars.search.models.CharacterPresenter
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchViewModel @ViewModelInject @Inject constructor(
    @UseCaseModule.SearchUseCase private val searchCharacterUseCase: SearchCharacterUseCase,
    @Assisted private  val savedStateHandle: SavedStateHandle,
) :
    ViewModel() {

    private val _characters = MutableLiveData<List<CharacterPresenter>>()
    val character: LiveData<List<CharacterPresenter>>
        get() = _characters

    fun searchCharacter(characterName: String) {
        viewModelScope.launch {
            searchCharacterUseCase(characterName).collect { characterList ->
                val characters = characterList.map {
                    it.toPresentation()
                }
                _characters.value = characters
            }
        }
    }
}