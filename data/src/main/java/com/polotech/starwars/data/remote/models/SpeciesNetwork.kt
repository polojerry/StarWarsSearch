package com.polotech.starwars.data.remote.models

import com.squareup.moshi.Json

data class SpeciesNetwork(
    val name :String,
    val language : String,

    @Json(name = "homeworld")
    val homeWorld : String
)