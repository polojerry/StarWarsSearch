package com.polotech.starwars.data.localsource.mapper

import com.polotech.starwars.data.localsource.models.CharacterEntity
import com.polotech.starwars.domain.models.CharacterModel

fun CharacterEntity.toDomain(): CharacterModel {
    return CharacterModel(
        name = name,
        height = height,
        url = url,
        birthYear = birthYear,
    )
}