package com.polotech.starwars.data.remote.models

import com.squareup.moshi.Json

data class CharacterNetwork(
    val name: String,
    val height: String,

    @field:Json(name = "birth_year")
    val birth_year: String,
    val url: String,
)