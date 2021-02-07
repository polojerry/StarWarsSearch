package com.polotech.starwars.search.mappers

import com.polotech.starwars.domain.models.CharacterModel
import com.polotech.starwars.search.models.CharacterPresenter
import com.polotech.starwars.search.util.cmToFeetConverter

fun CharacterModel.toPresentation(): CharacterPresenter {
    return CharacterPresenter(
        name = name,
        heightInCm = height,
        heightInFeet = cmToFeetConverter(height),
        birthYear = birthYear,
        url = url,
    )
}