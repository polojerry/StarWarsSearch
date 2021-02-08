package com.polotech.starwars.search.ui.details

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.polotech.starwars.search.models.CharacterPresenter
import javax.inject.Inject

class DetailsViewModel @ViewModelInject @Inject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _character = MutableLiveData<CharacterPresenter>()
    val character: LiveData<CharacterPresenter>
        get() = _character

    init {
        _character.value = savedStateHandle.get<CharacterPresenter>("character")
    }


}