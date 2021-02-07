package com.polotech.starwars.search.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.polotech.starwars.domain.models.CharacterModel
import com.polotech.starwars.domain.usecases.SearchCharacterUseCase
import com.polotech.starwars.search.di.UseCaseModule
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    @UseCaseModule.SearchUseCase val searchCharacterUseCase: SearchCharacterUseCase,
    private val savedStateHandle: SavedStateHandle,
) :
    ViewModel() {


}