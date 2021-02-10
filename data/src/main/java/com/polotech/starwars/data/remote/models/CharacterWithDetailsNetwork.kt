package com.polotech.starwars.data.remote.models

import com.squareup.moshi.Json

data class CharacterWithDetailsNetwork(
    val name: String,
    val height: String,

    @field:Json(name = "birth_year")
    val birthYear: String,
    val url: String,

    @field:Json(name = "films")
    val filmUrls: List<String>,

    @field:Json(name = "homeworld")
    val planetUrl: String,

    @field:Json(name = "species")
    val speciesUrls: List<String>,
)