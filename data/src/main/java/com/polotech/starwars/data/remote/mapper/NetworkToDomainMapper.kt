package com.polotech.starwars.data.remote.mapper

import com.polotech.starwars.data.remote.models.response.CharacterNetwork
import com.polotech.starwars.domain.models.CharacterModel

fun CharacterNetwork.toDomain(): CharacterModel {
    return CharacterModel(
        name = this.name,
        height = this.height,
        birthYear = this.birth_year,
        url = this.url

    )
}