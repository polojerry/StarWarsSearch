package com.polotech.starwars.data.remote.models

import com.squareup.moshi.Json

data class CharacterWithDetailsNetwork(
    val name: String,
    val height: String,

    @Json(name = "birth_year")
    val birthYear: String,
    val url: String,

    @Json(name = "films")
    val filmUrls: List<String>,

    @Json(name = "homeworld")
    val planetUrl: String,

    @Json(name = "species")
    val speciesUrls: List<String>,
)