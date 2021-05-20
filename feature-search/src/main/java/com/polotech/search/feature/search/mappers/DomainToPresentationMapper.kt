package com.polotech.search.feature.search.mappers

import com.polotech.search.feature.search.models.CharacterPresenter
import com.polotech.starwars.domain.models.*
import com.polotech.starwars.search.common.util.cmToFeetConverter

internal fun CharacterModel.toPresentation(): CharacterPresenter {
    return CharacterPresenter(
        name = name,
        heightInCm = height,
        heightInFeet = cmToFeetConverter(height),
        birthYear = birthYear,
        url = url,
    )
}